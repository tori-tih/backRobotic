package com.example.backrobotic.dto;

import com.example.backrobotic.entity.News;
import com.example.backrobotic.entity.Photo;
import com.example.backrobotic.repository.PhotoRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

public class NewsPojo {

    private Long id;
    private String name;
    private String description;
    private Date date;

    private String mainPhoto; //file
    private String info; //file
    private List<String> photos = new ArrayList<>(); //file - list

    private Boolean pub;

//    public static NewsPojo fromEntity(News entity){
//
//        NewsPojo pojo = new NewsPojo();
//        pojo.setId(entity.getId());
//        pojo.setName(entity.getName());
//        pojo.setDescription(entity.getDescription());
//        pojo.setDate(entity.getDate());
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
//    public static News toEntity(NewsPojo pojo){
//        News entity = new News();
//        entity.setId(pojo.getId());
//        entity.setName(pojo.getName());
//        entity.setDescription(pojo.getDescription());
//        entity.setDate(pojo.getDate());
//        entity.setMainPhoto(pojo.getMainPhoto());
//        entity.setInfo(pojo.getInfo());
////TODO ПРОВЕРИТЬ
//        List<Photo> photos = new ArrayList<>();
//
//        for (String photo : pojo.getPhotos()){
//            Photo photoE = new Photo();
//            photoE.setFile(photo);
//
////TODO сохрвнять в бд через репозиторий
//
//        }
//        entity.setPhotos(photos);
//        entity.setPub(pojo.getPub());
//
//        return entity;
//    }
}
