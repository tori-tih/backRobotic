package com.example.backrobotic.controller;

import com.example.backrobotic.dto.EventPojo;
import com.example.backrobotic.dto.NewsPojo;
import com.example.backrobotic.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<EventPojo> findAll() {return eventService.findAll();}

    @PostMapping
    public EventPojo addNew(
            @RequestPart("news") EventPojo news,
            @RequestPart("mainPhoto") MultipartFile mainPhoto,
            @RequestPart("photos") MultipartFile[] photos,
            @RequestPart("info") MultipartFile info) {
        return eventService.addNew(news, mainPhoto,  info);}

    @PutMapping
    public EventPojo update(
            @RequestPart("news") EventPojo news,
            @RequestPart("mainPhoto") MultipartFile mainPhoto,
            @RequestPart("photos") MultipartFile[] photos,
            @RequestPart("info") MultipartFile info) {
        return eventService.addNew(news, mainPhoto, info);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { eventService.delete(id);}
}
