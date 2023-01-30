package com.example.store.repository;

import com.example.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByName(String name);

    User findByRole(String role);
}
