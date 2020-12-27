package com.example.demo.controller.admin;

import com.example.demo.dao.domain.dto.UserDto;
import com.example.demo.dao.domain.model.UserEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.domain.UserService;
import com.example.demo.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/user/add")
    public ResponseEntity<String> addNewUser(@RequestBody UserDto dto) {

        try {
            userService.create(dto);

            return new ResponseEntity<>(
                    "User successful added",
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/user/delete")
    public ResponseEntity<String> deleteUser(@RequestParam String userName) {

        try {
            UserEntity byLogin = userService.findByLogin(userName);
            userService.delete(byLogin);

            return new ResponseEntity<>(
                    "User successful deleted",
                    HttpStatus.OK
            );

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserEntity> all = userService.findAll();
        return new ResponseEntity<>(
                userMapper.toListDto(all),
                HttpStatus.OK
        );
    }
}
