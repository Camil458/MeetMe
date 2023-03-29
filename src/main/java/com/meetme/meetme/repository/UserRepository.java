package com.meetme.meetme.repository;

import com.meetme.meetme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
