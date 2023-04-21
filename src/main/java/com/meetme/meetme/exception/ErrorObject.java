package com.meetme.meetme.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}
