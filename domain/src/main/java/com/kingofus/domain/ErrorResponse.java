package com.kingofus.domain;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorResponse {
    Integer statusCode;
    String errorMessage;
    String exceptionClass;
    LocalDateTime timeStamp;
    String url;
}