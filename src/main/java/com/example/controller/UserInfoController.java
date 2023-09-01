package com.example.controller;


import com.example.bean.UserInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class UserInfoController {
    @GetMapping("/user")
    public String addUser(@Validated(value = {UserInfo.Insert.class, Default.class}) UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getObjectName() + ": " + error.getDefaultMessage());
            }
        }

        if (bindingResult.hasFieldErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage()
                        + "，当前没通过校验规则的值是 " + fieldError.getRejectedValue());
            }
        }
        return "添加成功！";
    }

    @GetMapping("/username")
    public String checkUsername(@NotNull String username) {
        return "";
    }
}
