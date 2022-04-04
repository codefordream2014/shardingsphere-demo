package com.eric.shardingsphere.demo.controller;


import com.eric.shardingsphere.demo.entity.UserEntity;
import com.eric.shardingsphere.demo.model.UserRequest;
import com.eric.shardingsphere.demo.model.UserResponse;
import com.eric.shardingsphere.demo.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Api(value = "V2-User", tags = {"V2-User",})
@RequestMapping("/api/v1")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Add User", nickname = "addUser", notes = "Add User",
            response = UserResponse.class, tags = {"V2-User",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserResponse.class),
            @ApiResponse(code = 403, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserEntity> addUser(@ApiParam(value = "UserRequest", required = true)
                                       @RequestBody UserRequest request) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(request, user);
        user.setCreateTime(LocalDateTime.now());
        user.setLastUpdateTime(LocalDateTime.now());
        user.setUserId(Long.parseLong(randomDigitsOfNum(9)));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @ApiOperation(value = "Query User", nickname = "Query User", notes = "Query User",
            response = UserResponse.class, tags = {"V2-User",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserResponse.class),
            @ApiResponse(code = 403, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping(value = "/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserEntity> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userRepository.findByUserId(userId));
    }

    @ApiOperation(value = "Search User", nickname = "Search User", notes = "Search User",
            response = UserResponse.class, tags = {"V2-User",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserResponse.class),
            @ApiResponse(code = 403, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping(value = "/users/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserEntity>> getUser(String name) {
        return ResponseEntity.ok(userRepository.findByName(name));
    }


    public static String randomDigitsOfNum(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            SecureRandom rand = new SecureRandom();
            int randomInt = rand.nextInt(9);
            result.append(randomInt);
        }
        return result.toString();
    }
}
