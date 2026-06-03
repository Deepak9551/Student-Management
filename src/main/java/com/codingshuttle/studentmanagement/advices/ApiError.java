package com.codingshuttle.studentmanagement.advices;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Builder
public class ApiError {
    private String message;

    private HttpStatus status;

    private List<String> subErrors;
}
