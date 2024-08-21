package com.ajtech.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

}
