package com.example.backrobotic.controller;

import com.example.backrobotic.dto.NewsPojo;
import com.example.backrobotic.dto.UserPojo;
import com.example.backrobotic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserPojo> findAll() {return userService.findAll();}

    @PostMapping
    public UserPojo addNew(
            @RequestBody UserPojo user) {
        return userService.addNew(user);}

    @PutMapping
    public UserPojo update(
            @RequestBody UserPojo user) {
        return userService.addNew(user);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { userService.delete(id);}
}
