package com.meetme.meetme.repository;

import com.meetme.meetme.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
