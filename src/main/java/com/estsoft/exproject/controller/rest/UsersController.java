package com.estsoft.exproject.controller.rest;

import com.estsoft.exproject.entity.Users;
import com.estsoft.exproject.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users users) {
        return ResponseEntity.ok(usersService.register(users));
    }
}
