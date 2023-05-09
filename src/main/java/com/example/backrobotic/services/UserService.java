package com.example.backrobotic.services;

import com.example.backrobotic.dto.EventPojo;
import com.example.backrobotic.dto.UserPojo;
import com.example.backrobotic.entity.Event;
import com.example.backrobotic.entity.User;
import com.example.backrobotic.mapper.UserMapper;
import com.example.backrobotic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public List<UserPojo> findAll() {
        List<UserPojo> res = new ArrayList<>();
        for(User x : userRepository.findAll())
            res.add(userMapper.fromEntity(x));
        return res;
    }

    public UserPojo addNew(UserPojo user) {
        return userMapper.fromEntity(userRepository.save(userMapper.toEntity(user)));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
