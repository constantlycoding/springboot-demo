package com.azkamis.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @RequiredArgsConstructor
public class ApiResponse<T> {

    private final int status;
    private final String message;
    private Object result;

}
