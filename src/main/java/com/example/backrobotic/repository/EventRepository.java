package com.example.backrobotic.repository;

import com.example.backrobotic.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
