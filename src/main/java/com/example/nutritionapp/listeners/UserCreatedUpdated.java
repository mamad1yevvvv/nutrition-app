package com.example.nutritionapp.listeners;


import com.example.nutritionapp.user.entity.User;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

public class UserCreatedUpdated  {

    @PrePersist
    public void createdUpdated(User user){
        user.setCreatedAt(LocalDateTime.now());
    }
}
