package com.example.backrobotic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "news", schema = "public")
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    //TODO: добавть mainPhoto
}
