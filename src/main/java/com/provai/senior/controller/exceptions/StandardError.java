package com.provai.senior.controller.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class StandardError {
    private Instant time;
    private Integer status;
    private String error;
    private String message;
    private String path;
}