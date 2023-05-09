package com.example.backrobotic.dto;

import com.example.backrobotic.entity.Event;
import com.example.backrobotic.entity.News;
import com.example.backrobotic.entity.Photo;
import com.example.backrobotic.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class EventPojo {
    private Long id;
    private String name;
    private Date date;
    private String address; //!!!!!

    private String mainPhoto; //file
    private String info; //file
    private List<UserPojo> users = new ArrayList<>(); //!!!!!
    private Boolean pub;

//    public static EventPojo fromEntity(Event entity){
//        EventPojo pojo = new EventPojo();
//        pojo.setId(entity.getId());
//        pojo.setName(entity.getName());
//
//        pojo.setDate(entity.getDate());
//        pojo.setAddress(entity.getAddress());
//        pojo.setMainPhoto(entity.getMainPhoto());
//        pojo.setInfo(entity.getInfo());
//        pojo.setPub(entity.getPub());
//        List<UserPojo> users = new ArrayList<>();
//        for(User user: entity.getUsers()){
////            users.add(UserPojo.fromEntity(user));
//        }
//        pojo.setUsers(users);
//        return pojo;
//    }
//
//    public static Event toEntity(EventPojo pojo){
//        Event entity = new Event();
//        entity.setId(pojo.getId());
//        entity.setName(pojo.getName());
//        entity.setAddress(pojo.getAddress());
//        entity.setDate(pojo.getDate());
//        entity.setMainPhoto(pojo.getMainPhoto());
//        entity.setInfo(pojo.getInfo());
//        entity.setPub(pojo.getPub());
//        List<User> users = new ArrayList<>();
//        for(UserPojo user: pojo.getUsers()){
////            users.add(UserPojo.toEntity(user));
//        }
//        entity.setUsers(users);
//        return entity;
//    }
}
