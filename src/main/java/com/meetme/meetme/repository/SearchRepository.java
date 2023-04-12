package com.meetme.meetme.repository;

import com.meetme.meetme.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Long> {
}
