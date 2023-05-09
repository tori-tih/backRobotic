package com.example.backrobotic.services;

import com.example.backrobotic.dto.NewsPojo;
import com.example.backrobotic.entity.News;
import com.example.backrobotic.mapper.NewsMapper;
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
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;
    public List<NewsPojo> findAll() {
        List<NewsPojo> res = new ArrayList<>();
        for(News author : newsRepository.findAll())
            res.add(newsMapper.fromEntity(author));
        return res;
    }

    public NewsPojo addNew(NewsPojo news, MultipartFile mainPhoto, MultipartFile[] photos, MultipartFile info) {
        File fileMainPhoto = new File(PathImage.IMAGE_PATH.getPath()+"newsIMG"+news.getId()+".png");
        File fileInfo = new File(PathImage.IMAGE_PATH.getPath()+"newsInfo"+news.getId()+".png");
        File[] filesPhotos = new File[photos.length];
        List<String> pPhotos = new ArrayList<>();
        for (int i=0; i<filesPhotos.length; i++){
            filesPhotos[i] = new File(PathImage.IMAGE_PATH.getPath()+news.getId()+"newsI"+i+".png");
            try(FileOutputStream out = new FileOutputStream(filesPhotos[i]);) {
                filesPhotos[i].createNewFile();
                out.write(mainPhoto.getBytes());
                pPhotos.add(filesPhotos[i].getName());//work? TODO
            }catch (Exception e){
                if(filesPhotos[i].exists())
                    filesPhotos[i].delete();
                throw new RuntimeException(e);
            }
        }
        news.setPhotos(pPhotos);
        try(FileOutputStream out = new FileOutputStream(fileMainPhoto);) {
            fileMainPhoto.createNewFile();
            out.write(mainPhoto.getBytes());
            news.setMainPhoto(fileMainPhoto.getName());//work? TODO
        }catch (Exception e){
            if(fileMainPhoto.exists())
                fileMainPhoto.delete();
            throw new RuntimeException(e);
        }
        try(FileOutputStream out = new FileOutputStream(fileInfo);) {
            fileInfo.createNewFile();
            out.write(info.getBytes());
            news.setInfo(fileInfo.getName());//work? TODO
        }catch (Exception e){
            if(fileInfo.exists())
                fileInfo.delete();
            throw new RuntimeException(e);
        }
        return newsMapper.fromEntity(newsRepository.save(newsMapper.toEntity(news)));
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}
