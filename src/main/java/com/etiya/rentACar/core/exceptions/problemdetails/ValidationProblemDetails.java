package com.etiya.rentacar.core.exceptions.problemdetails;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails() {
        setTitle("Business Rule Violation");
        setDetail("Validation Problem");
        setType("https://etiya.com/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());

    }
    private List<Map<String,String>> errors;
}
