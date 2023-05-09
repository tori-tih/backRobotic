package com.example.backrobotic.services;

import com.example.backrobotic.dto.NewsPojo;
import com.example.backrobotic.dto.ProjectPojo;
import com.example.backrobotic.entity.News;
import com.example.backrobotic.entity.Project;
import com.example.backrobotic.mapper.ProjectMapper;
import com.example.backrobotic.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    public List<ProjectPojo> findAll() {
        List<ProjectPojo> res = new ArrayList<>();
        for(Project x : projectRepository.findAll())
            res.add(projectMapper.fromEntity(x));
        return res;
    }

    public ProjectPojo addNew(ProjectPojo projectPojo, MultipartFile mainPhoto, MultipartFile[] photos, MultipartFile info) {
        File fileMainPhoto = new File(PathImage.IMAGE_PATH.getPath()+"newsIMG"+projectPojo.getId()+".png");
        File fileInfo = new File(PathImage.IMAGE_PATH.getPath()+"newsInfo"+projectPojo.getId()+".png");
        File[] filesPhotos = new File[photos.length];
        List<String> pPhotos = new ArrayList<>();
        for (int i=0; i<filesPhotos.length; i++){
            filesPhotos[i] = new File(PathImage.IMAGE_PATH.getPath()+projectPojo.getId()+"newsI"+i+".png");
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
        projectPojo.setPhotos(pPhotos);
        try(FileOutputStream out = new FileOutputStream(fileMainPhoto);) {
            fileMainPhoto.createNewFile();
            out.write(mainPhoto.getBytes());
            projectPojo.setMainPhoto(fileMainPhoto.getName());//work? TODO
        }catch (Exception e){
            if(fileMainPhoto.exists())
                fileMainPhoto.delete();
            throw new RuntimeException(e);
        }
        try(FileOutputStream out = new FileOutputStream(fileInfo);) {
            fileInfo.createNewFile();
            out.write(info.getBytes());
            projectPojo.setInfo(fileInfo.getName());//work? TODO
        }catch (Exception e){
            if(fileInfo.exists())
                fileInfo.delete();
            throw new RuntimeException(e);
        }
        return projectMapper.fromEntity(projectRepository.save(projectMapper.toEntity(projectPojo)));
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
