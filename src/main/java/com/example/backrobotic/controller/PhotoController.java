package com.example.backrobotic.controller;


import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/photo")
public class PhotoController {
    @GetMapping
    public byte[] getPhoto(@RequestBody String path) throws IOException {
        return Files.readAllBytes(new File(path).toPath());
    }
    @GetMapping("photos")
    public List<byte[]> getPhoto(@RequestBody String[] paths) throws IOException {
        List<byte[]> res = new ArrayList<>();
        for(String p: paths){
            res.add(Files.readAllBytes(new File(p).toPath()));
        }
        return res;
    }
}
