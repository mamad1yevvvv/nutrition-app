package com.example.nutritionapp.user;

import com.example.nutritionapp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findUserByEmail(String email);
    User findByEmail(String email);
    List<User> findAll();

}
