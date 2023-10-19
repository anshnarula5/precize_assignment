package com.precizeassignment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationErrorResponse {
    private int statusCode;
    private String message;
    private long timestamp;
}
