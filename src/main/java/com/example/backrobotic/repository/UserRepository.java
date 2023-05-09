package com.example.backrobotic.repository;

import com.example.backrobotic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
