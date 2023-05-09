package com.example.backrobotic.dto;

import com.example.backrobotic.entity.News;
import com.example.backrobotic.entity.Photo;
import com.example.backrobotic.entity.Project;
import com.example.backrobotic.repository.PhotoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProjectPojo {
    private Long id;
    private String name;
    private String description;

    private String mainPhoto; //file
    private String info; //file
    private List<String> photos = new ArrayList<>(); //file - list

    private Boolean pub;
//    public static ProjectPojo fromEntity(Project entity){
//        ProjectPojo pojo = new ProjectPojo();
//        pojo.setId(entity.getId());
//        pojo.setName(entity.getName());
//        pojo.setDescription(entity.getDescription());
//        pojo.setMainPhoto(entity.getMainPhoto());
//        pojo.setInfo(entity.getInfo());
//        List<String> photos = new ArrayList<>();
//        for (Photo photo : entity.getPhotos()){
//            photos.add(photo.getFile());
//        }
//        pojo.setPhotos(photos);
//        pojo.setPub(entity.getPub());
//
//        return pojo;
//    }
//
//    public static Project toEntity(ProjectPojo pojo){
//        Project entity = new Project();
//        entity.setId(pojo.getId());
//        entity.setName(pojo.getName());
//        entity.setDescription(pojo.getDescription());
//        entity.setMainPhoto(pojo.getMainPhoto());
//        entity.setInfo(pojo.getInfo());
////TODO ПРОВЕРИТЬ
//        List<Photo> photos = new ArrayList<>();
//        for (String photo : pojo.getPhotos()){
//            Photo photoE = new Photo();
//            photoE.setFile(photo);
//            //TODO сохрвнять в бд через репозиторий
//        }
//        entity.setPhotos(photos);
//        entity.setPub(pojo.getPub());
//
//        return entity;
//    }
}
