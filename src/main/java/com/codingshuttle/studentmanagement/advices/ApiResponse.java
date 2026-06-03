package com.codingshuttle.studentmanagement.advices;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponse <T>{
    private T data;
    private ApiError error;
    private boolean success;

}
