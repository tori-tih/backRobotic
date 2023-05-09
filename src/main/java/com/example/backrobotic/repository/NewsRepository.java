package com.example.backrobotic.repository;

import com.example.backrobotic.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
