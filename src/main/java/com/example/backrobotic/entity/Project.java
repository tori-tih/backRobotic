package com.example.backrobotic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project", schema = "public")
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private String mainPhoto; //file

    private String info; //file

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();

    private Boolean pub;
}
