package com.example.bean;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserInfo {
    @Null(groups = Insert.class)
    @NotNull(groups = Update.class)
    private Long id;
    // name不能为null、空串、或全是空格的非空串
    @NotBlank(message = "Your name should not be null or blank.")
    private String name;
    // age为正整数，[1, 800]
    @NotNull
    @Min(value = 18, message = "Your age is less than {value}.")
    @Max(800)
//    @Range(min = 1, max = 800)
    private Integer age;
    // 格式正确
    @NotBlank
    @Email
    private String email;
    // 为中国大陆的手机号
    @Pattern(regexp = "^(1[3456789]\\d{9}|(13[0-9]|14[5-9]|15[0-35-9]|16[6]|17[0-8]|18[0-9]|19[89])\\d{8})$")
    private String phone;
    // 不能为null，在当前日期之前
    @NotNull
    @Past
    private LocalDateTime birthday;
    // 符合url的规范
    @URL
    private String personalPage;

    @NotNull
    @Valid
    private Grade grade;

    public interface Insert {}

    public interface Update {}
}
