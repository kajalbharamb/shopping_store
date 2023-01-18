package com.example.store.repository;
import com.example.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User,String> {
    User findByName(String name);
    User findByRole(String role);
}
