package com.example.nutritionapp.nutrition;

import com.example.nutritionapp.nutrition.dto.NutritionDTO;
import com.example.nutritionapp.nutrition.dto.ResponseDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;

import java.io.File;

@FeignClient(value = "food", url = "https://api.logmeal.es/v2")
public interface NutritionFeign {

    @PostMapping(value = "/image/segmentation/complete/v1.0?language=eng", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Headers("Content-Type: multipart/form-data")
    ResponseDTO getInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                        @RequestPart(name = "image") File imageData);

    @PostMapping(value = "/recipe/nutritionalInfo")
    String getNutritionInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                            @RequestBody NutritionDTO nutritionDTO);
}
