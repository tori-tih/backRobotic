package com.example.backrobotic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;

    private String institution;
    private String mail;

    private Role role;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Project> projectsRedactor = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Event> eventsRedactor = new ArrayList<>();

    private String password;
}
