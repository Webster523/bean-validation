package com.example.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserInfo {
    private Long id;
    // name不能为null、空串、或全是空格的非空串
    private String name;
    // age为正整数，[1, 800]
    private Integer age;
    // 格式正确
    private String email;
    // 为中国大陆的手机号
    private String phone;
    // 在当前日期之前
    private LocalDateTime birthday;
    // 符合url的规范
    private String personalPage;
}
