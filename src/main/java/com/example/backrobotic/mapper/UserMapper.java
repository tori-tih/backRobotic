package com.example.backrobotic.mapper;

import com.example.backrobotic.dto.EventPojo;
import com.example.backrobotic.dto.ProjectPojo;
import com.example.backrobotic.dto.UserPojo;
import com.example.backrobotic.entity.Event;
import com.example.backrobotic.entity.Project;
import com.example.backrobotic.entity.Role;
import com.example.backrobotic.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component()
@AllArgsConstructor
public class UserMapper {
    private final ProjectMapper projectMapper;
    private final EventMapper eventMapper;
    public  UserPojo fromEntity(User entity){
        UserPojo pojo = new UserPojo();
        pojo.setId(entity.getId());
        pojo.setFirstname(entity.getFirstname());
        pojo.setLastname(entity.getLastname());
        pojo.setBirthdate(entity.getBirthdate());
        pojo.setInstitution(entity.getInstitution());
        pojo.setMail(entity.getMail());
        pojo.setRole(entity.getRole().toString());
        List<ProjectPojo> projectsRedactor = new ArrayList<>();
        for(Project ent: entity.getProjectsRedactor()){
            projectsRedactor.add(projectMapper.fromEntity(ent));
        }
        pojo.setProjectsRedactor(projectsRedactor);
        List<EventPojo> eventsRedactor = new ArrayList<>();
        for(Event ent: entity.getEventsRedactor()){
            eventsRedactor.add(eventMapper.fromEntity(ent));
        }
        pojo.setEventsRedactor(eventsRedactor);
        pojo.setPassword(entity.getPassword());

        return pojo;
    }

    public  User toEntity(UserPojo pojo){
        User entity = new User();
        entity.setId(pojo.getId());
        entity.setFirstname(pojo.getFirstname());
        entity.setLastname(pojo.getLastname());
        entity.setBirthdate(pojo.getBirthdate());
        entity.setInstitution(pojo.getInstitution());
        entity.setMail(pojo.getMail());
        entity.setRole(Role.valueOf(pojo.getRole()));
        List<Project> projectsRedactor = new ArrayList<>();
        for(ProjectPojo ent: pojo.getProjectsRedactor()){
            projectsRedactor.add(projectMapper.toEntity(ent));
        }
        entity.setProjectsRedactor(projectsRedactor);
        List<Event> eventsRedactor = new ArrayList<>();
        for(EventPojo ent: pojo.getEventsRedactor()){
            eventsRedactor.add(eventMapper.toEntity(ent));
        }
        entity.setEventsRedactor(eventsRedactor);
        entity.setPassword(pojo.getPassword());

        return entity;
    }
}
