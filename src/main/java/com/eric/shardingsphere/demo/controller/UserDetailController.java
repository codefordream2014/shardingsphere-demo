package com.eric.shardingsphere.demo.controller;


import com.eric.shardingsphere.demo.entity.UserDetailEntity;
import com.eric.shardingsphere.demo.repository.UserDetailRepository;
import com.eric.shardingsphere.demo.model.UserDetailRequest;
import com.eric.shardingsphere.demo.model.UserResponse;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Api(value = "V2-User-Detail", tags = {"V2-User-Detail",})
@RequestMapping("/api/v1")
@RestController
public class UserDetailController {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @ApiOperation(value = "Add User", nickname = "addUser", notes = "Add User",
            response = UserResponse.class, tags = {"V2-User-Detail",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserResponse.class),
            @ApiResponse(code = 403, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping(value = "/users/detail", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserDetailEntity> addUser(@ApiParam(value = "UserDetailRequest", required = true)
                                             @RequestBody UserDetailRequest request) {
        UserDetailEntity userDetail = new UserDetailEntity();
        BeanUtils.copyProperties(request, userDetail);
        userDetail.setCreateTime(LocalDateTime.now());
        userDetail.setLastUpdateTime(LocalDateTime.now());
        return ResponseEntity.ok(userDetailRepository.save(userDetail));
    }

    @ApiOperation(value = "Query User", nickname = "Query User", notes = "Query User",
            response = UserResponse.class, tags = {"V2-User-Detail",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserResponse.class),
            @ApiResponse(code = 403, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping(value = "/users/{userId}/detail", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserDetailEntity> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userDetailRepository.findByUserId(userId));
    }

    @ApiOperation(value = "Search User", nickname = "Search User", notes = "Search User",
            response = UserResponse.class, tags = {"V2-User-Detail",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserResponse.class),
            @ApiResponse(code = 403, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping(value = "/users/search/detail", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserDetailEntity>> getUser(String phone) {
        return ResponseEntity.ok(userDetailRepository.findByPhone(phone));
    }
}
