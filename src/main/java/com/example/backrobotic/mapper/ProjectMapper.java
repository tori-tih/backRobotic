package com.example.backrobotic.mapper;


import com.example.backrobotic.dto.ProjectPojo;
import com.example.backrobotic.entity.Photo;
import com.example.backrobotic.entity.Project;
import com.example.backrobotic.repository.PhotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component()
@AllArgsConstructor
public class ProjectMapper {
    private final PhotoRepository photoRepository;
    public ProjectPojo fromEntity(Project entity){
        ProjectPojo pojo = new ProjectPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setDescription(entity.getDescription());
        pojo.setMainPhoto(entity.getMainPhoto());
        pojo.setInfo(entity.getInfo());
        List<String> photos = new ArrayList<>();
        for (Photo photo : entity.getPhotos()){
            photos.add(photo.getFile());
        }
        pojo.setPhotos(photos);
        pojo.setPub(entity.getPub());

        return pojo;
    }

    public Project toEntity(ProjectPojo pojo){
        Project entity = new Project();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setDescription(pojo.getDescription());
        entity.setMainPhoto(pojo.getMainPhoto());
        entity.setInfo(pojo.getInfo());
//TODO ПРОВЕРИТЬ
        List<Photo> photos = new ArrayList<>();
        for (String photo : pojo.getPhotos()){
            Photo photoE = new Photo();
            photoE.setFile(photo);
            photos.add(this.photoRepository.save(photoE));
        }
        entity.setPhotos(photos);
        entity.setPub(pojo.getPub());

        return entity;
    }
}
