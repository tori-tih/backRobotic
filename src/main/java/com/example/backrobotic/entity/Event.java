package com.example.backrobotic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event", schema = "public")
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    private String address;

    private String mainPhoto; //file

    private String info; //file

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    private Boolean pub;
}
