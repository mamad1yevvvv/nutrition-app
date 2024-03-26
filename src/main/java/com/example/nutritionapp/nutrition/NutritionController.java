package com.example.nutritionapp.nutrition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/nutrition")
@RequiredArgsConstructor
public class NutritionController {
    private final NutritionService service;
    @PostMapping( value = "/info", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> setPhoto(@RequestBody MultipartFile image){
        String response = service.sendPhotoAndGetInfo(image);
        return ResponseEntity.ok(response);
    }
}
