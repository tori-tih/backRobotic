package com.example.backrobotic.controller;

import com.example.backrobotic.dto.NewsPojo;
import com.example.backrobotic.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsPojo> findAll() {return newsService.findAll();}

    @PostMapping
    public NewsPojo addNew(
            @RequestPart("news") NewsPojo news,
            @RequestPart("mainPhoto") MultipartFile mainPhoto,
            @RequestPart("photos") MultipartFile[] photos,
            @RequestPart("info") MultipartFile info) {
        return newsService.addNew(news, mainPhoto, photos, info);}

    @PutMapping
    public NewsPojo update(
            @RequestPart("news") NewsPojo news,
            @RequestPart("mainPhoto") MultipartFile mainPhoto,
            @RequestPart("photos") MultipartFile[] photos,
            @RequestPart("info") MultipartFile info) {
        return newsService.addNew(news, mainPhoto, photos, info);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { newsService.delete(id);}
}
