package com.example.nutritionapp.nutrition;

import com.example.nutritionapp.nutrition.dto.NutritionDTO;
import com.example.nutritionapp.nutrition.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
@Service
@RequiredArgsConstructor
public class NutritionService {
    private final NutritionFeign feign;
    private final String BEARER_TOKEN = "Bearer 04ae404054355d32d3e136b89b537f91a8e184fa";
    public String sendPhotoAndGetInfo(MultipartFile multipartFile)  {
        try {
            File file = convert(multipartFile);
            ResponseDTO info = feign.getInfo(BEARER_TOKEN, file);
            int imageId = info.getImageId();
            System.out.println("imageId = " + imageId);
            return feign.getNutritionInfo(BEARER_TOKEN, new NutritionDTO(imageId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }
}
