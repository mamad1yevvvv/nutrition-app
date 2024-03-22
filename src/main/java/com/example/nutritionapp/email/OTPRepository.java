package com.example.nutritionapp.email;

import com.example.nutritionapp.email.entity.OTP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends CrudRepository<OTP, String> {
}
