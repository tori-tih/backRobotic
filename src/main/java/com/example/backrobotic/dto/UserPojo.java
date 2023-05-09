package com.example.backrobotic.dto;


import com.example.backrobotic.entity.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserPojo {
    private Long id;

    private String firstname;
    private String lastname;
    private Date birthdate;

    private String institution;
    private String mail;

    private String role;

    private List<ProjectPojo> projectsRedactor = new ArrayList<>();

    private List<EventPojo> eventsRedactor = new ArrayList<>();

    private String password;

//    public static UserPojo fromEntity(User entity){
//        UserPojo pojo = new UserPojo();
//        pojo.setId(entity.getId());
//        pojo.setFirstname(entity.getFirstname());
//        pojo.setLastname(entity.getLastname());
//        pojo.setBirthdate(entity.getBirthdate());
//        pojo.setInstitution(entity.getInstitution());
//        pojo.setMail(entity.getMail());
//        pojo.setRole(entity.getRole().toString());
//        List<ProjectPojo> projectsRedactor = new ArrayList<>();
//        for(Project ent: entity.getProjectsRedactor()){
////            projectsRedactor.add(ProjectPojo.fromEntity(ent));
//        }
//        pojo.setProjectsRedactor(projectsRedactor);
//        List<EventPojo> eventsRedactor = new ArrayList<>();
//        for(Event ent: entity.getEventsRedactor()){
//            eventsRedactor.add(EventPojo.fromEntity(ent));
//        }
//        pojo.setEventsRedactor(eventsRedactor);
//        pojo.setPassword(entity.getPassword());
//
//        return pojo;
//    }
//
//    public static User toEntity(UserPojo pojo){
//        User entity = new User();
//        entity.setId(pojo.getId());
//        entity.setFirstname(pojo.getFirstname());
//        entity.setLastname(pojo.getLastname());
//        entity.setBirthdate(pojo.getBirthdate());
//        entity.setInstitution(pojo.getInstitution());
//        entity.setMail(pojo.getMail());
//        entity.setRole(Role.valueOf(pojo.getRole()));
//        List<Project> projectsRedactor = new ArrayList<>();
//        for(ProjectPojo ent: pojo.getProjectsRedactor()){
////            projectsRedactor.add(ProjectPojo.toEntity(ent));
//        }
//        entity.setProjectsRedactor(projectsRedactor);
//        List<Event> eventsRedactor = new ArrayList<>();
//        for(EventPojo ent: pojo.getEventsRedactor()){
//            eventsRedactor.add(EventPojo.toEntity(ent));
//        }
//        entity.setEventsRedactor(eventsRedactor);
//        entity.setPassword(pojo.getPassword());
//
//        return entity;
//    }
}
