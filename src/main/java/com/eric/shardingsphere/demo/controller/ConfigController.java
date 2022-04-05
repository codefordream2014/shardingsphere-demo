package com.eric.shardingsphere.demo.controller;

import com.eric.shardingsphere.demo.entity.ConfigEntity;
import com.eric.shardingsphere.demo.model.ConfigRequest;
import com.eric.shardingsphere.demo.model.UserResponse;
import com.eric.shardingsphere.demo.repository.ConfigRepository;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Api(value = "V2-Config", tags = {"V2-Config",})
@RequestMapping("/api/v1")
@RestController
public class ConfigController {

    @Autowired
    private ConfigRepository configRepository;

    @ApiOperation(value = "Add Config", nickname = "addConfig", notes = "Add Config",
            response = UserResponse.class, tags = {"V2-Config",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserResponse.class),
            @ApiResponse(code = 403, message = "Invalid Data"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping(value = "/config", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<ConfigEntity> addConfig(@ApiParam(value = "ConfigRequest", required = true)
                                           @RequestBody ConfigRequest request) {
        ConfigEntity config = new ConfigEntity();
        BeanUtils.copyProperties(request, config);
        config.setCreateTime(LocalDateTime.now());
        config.setLastUpdateTime(LocalDateTime.now());
        config.setId(Long.parseLong(randomDigitsOfNum(9)));
        return ResponseEntity.ok(configRepository.save(config));
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
