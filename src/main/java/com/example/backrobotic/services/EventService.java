package com.example.backrobotic.services;

import com.example.backrobotic.dto.EventPojo;
import com.example.backrobotic.dto.NewsPojo;
import com.example.backrobotic.entity.Event;
import com.example.backrobotic.entity.News;
import com.example.backrobotic.mapper.EventMapper;
import com.example.backrobotic.mapper.NewsMapper;
import com.example.backrobotic.repository.EventRepository;
import com.example.backrobotic.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public List<EventPojo> findAll() {
        List<EventPojo> res = new ArrayList<>();
        for(Event x : eventRepository.findAll())
            res.add(eventMapper.fromEntity(x));
        return res;
    }

    public EventPojo addNew(EventPojo event, MultipartFile mainPhoto, MultipartFile info) {
        File fileMainPhoto = new File(PathImage.IMAGE_PATH.getPath()+"newsIMG"+event.getId()+".png");
        File fileInfo = new File(PathImage.IMAGE_PATH.getPath()+"newsInfo"+event.getId()+".png");
        try(FileOutputStream out = new FileOutputStream(fileMainPhoto);) {
            fileMainPhoto.createNewFile();
            out.write(mainPhoto.getBytes());
            event.setMainPhoto(fileMainPhoto.getName());//work? TODO
        }catch (Exception e){
            if(fileMainPhoto.exists())
                fileMainPhoto.delete();
            throw new RuntimeException(e);
        }
        try(FileOutputStream out = new FileOutputStream(fileInfo);) {
            fileInfo.createNewFile();
            out.write(info.getBytes());
            event.setInfo(fileInfo.getName());//work? TODO
        }catch (Exception e){
            if(fileInfo.exists())
                fileInfo.delete();
            throw new RuntimeException(e);
        }
        return eventMapper.fromEntity(eventRepository.save(eventMapper.toEntity(event)));
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
