package com.example.backrobotic.controller;

import com.example.backrobotic.dto.NewsPojo;
import com.example.backrobotic.dto.ProjectPojo;
import com.example.backrobotic.services.NewsService;
import com.example.backrobotic.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectPojo> findAll() {return projectService.findAll();}

    @PostMapping
    public ProjectPojo addNew(
            @RequestPart("news") ProjectPojo project,
            @RequestPart("mainPhoto") MultipartFile mainPhoto,
            @RequestPart("photos") MultipartFile[] photos,
            @RequestPart("info") MultipartFile info) {
        return projectService.addNew(project, mainPhoto, photos, info);}

    @PutMapping
    public ProjectPojo update(
            @RequestPart("news") ProjectPojo project,
            @RequestPart("mainPhoto") MultipartFile mainPhoto,
            @RequestPart("photos") MultipartFile[] photos,
            @RequestPart("info") MultipartFile info) {
        return projectService.addNew(project, mainPhoto, photos, info);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { projectService.delete(id);}
}
