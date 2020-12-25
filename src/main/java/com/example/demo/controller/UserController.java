package com.example.demo.controller;

import com.example.demo.dao.domain.dto.UserDto;
import com.example.demo.dao.domain.model.UserEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder encoder;

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody UserDto userDto) {

        try {
            userService.create(userDto);
            return new ResponseEntity<>(
                    "Registration successful",
                    HttpStatus.OK
            );

        } catch (UserAlreadyExistException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/changepassword")
    public ResponseEntity<String> changePassword(@RequestParam String newPassword, Principal principal) {

        try {
            UserEntity byLogin = userService.findByLogin(principal.getName());
            byLogin.setPassword(encoder.encode(newPassword));
            userService.save(byLogin);

            return new ResponseEntity<>(
                    "Password was updated",
                    HttpStatus.OK
            );

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    "Something wrong: can't find user in database",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


}
