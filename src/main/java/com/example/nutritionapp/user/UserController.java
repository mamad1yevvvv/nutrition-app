package com.example.nutritionapp.user;

import com.example.nutritionapp.user.dto.UserBaseDto;
import com.example.nutritionapp.user.dto.UserPatchDto;
import com.example.nutritionapp.user.dto.UserResponseDto;
import com.example.nutritionapp.user.dto.UserUpdateDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> patchUser(@PathVariable Long id, @RequestBody UserPatchDto patchDto)  {
        UserResponseDto responseDto = userService.updateUser(patchDto , id);
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserBaseDto> getUser(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserProfile(id));
    }
}
