package com.example.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserInfo {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String phone;
    private LocalDateTime birthday;
    private String personalPage;
}
