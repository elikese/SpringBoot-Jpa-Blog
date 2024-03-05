package com.study.blog.controller.api;

import com.study.blog.model.RoleType;
import com.study.blog.model.User;
import com.study.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/user")
    public ResponseEntity<?> join(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return ResponseEntity
                .ok()
                .body(user);
    }
}