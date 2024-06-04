package com.desafio.viacep.infrastructure.controller.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private Integer statusCode;
    private Date timestamp;
    private String message;
}