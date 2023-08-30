package com.example.bean;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grade {
    @NotBlank
    private String no;
}