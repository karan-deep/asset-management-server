package com.project.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Generating parameterized constructor, getter and setter using lombok
@Getter
@Setter
@AllArgsConstructor

public class ErrorResponse {
    private String message;
}
