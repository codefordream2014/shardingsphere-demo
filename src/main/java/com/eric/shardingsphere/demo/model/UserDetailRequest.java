package com.eric.shardingsphere.demo.model;


import lombok.Data;

@Data
public class UserDetailRequest {
    private String address;
    private String phone;
    private Long userId;
}
