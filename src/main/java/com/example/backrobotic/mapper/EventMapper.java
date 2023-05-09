package com.example.backrobotic.mapper;

import com.example.backrobotic.dto.EventPojo;
import com.example.backrobotic.dto.UserPojo;
import com.example.backrobotic.entity.Event;
import com.example.backrobotic.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component()
@AllArgsConstructor
public class EventMapper {
    private final UserMapper userMapper;
    public  EventPojo fromEntity(Event entity){
        EventPojo pojo = new EventPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());

        pojo.setDate(entity.getDate());
        pojo.setAddress(entity.getAddress());
        pojo.setMainPhoto(entity.getMainPhoto());
        pojo.setInfo(entity.getInfo());
        pojo.setPub(entity.getPub());
        List<UserPojo> users = new ArrayList<>();
        for(User user: entity.getUsers()){
            users.add(userMapper.fromEntity(user));
        }
        pojo.setUsers(users);
        return pojo;
    }

    public  Event toEntity(EventPojo pojo){
        Event entity = new Event();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setAddress(pojo.getAddress());
        entity.setDate(pojo.getDate());
        entity.setMainPhoto(pojo.getMainPhoto());
        entity.setInfo(pojo.getInfo());
        entity.setPub(pojo.getPub());
        List<User> users = new ArrayList<>();
        for(UserPojo user: pojo.getUsers()){
            users.add(userMapper.toEntity(user));
        }
        entity.setUsers(users);
        return entity;
    }
}
