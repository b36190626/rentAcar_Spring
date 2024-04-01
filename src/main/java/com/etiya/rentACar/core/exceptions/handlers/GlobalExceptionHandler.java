package com.etiya.rentacar.core.exceptions.handlers;

import com.etiya.rentacar.core.exceptions.problemdetails.BusinessProblemDetails;
import com.etiya.rentacar.core.exceptions.problemdetails.ValidationProblemDetails;
import com.etiya.rentacar.core.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException){
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(businessException.getMessage());
        return businessProblemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class}) //try catch
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception){
        List<Map<String,String>> errorList = exception.getBindingResult().getFieldErrors().stream().map(
                fieldError -> {
                    Map<String,String> validationError = new HashMap<>();
                    validationError.put(fieldError.getField(),fieldError.getDefaultMessage());
                    return validationError;
                }).collect(Collectors.toList());
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(errorList);
        return validationProblemDetails;

    }
//    public void invokemethod(){
//        try {
//            int[] myNumbers = {1, 2, 3};
//            System.out.println(myNumbers[10]);
//        } catch (Exception e) {
//            System.out.println("Something went wrong.");
//        } catch (Exception ese) {
//            System.out.println("Something went wrong2.");
//        } catch (Exception eeees) {
//            System.out.println("Something went wrong3.");
//        }
//    }
}

//internalservererror => exception,problemdetails,handleException
//exception türlerini araştırın.
//500 internal server error
//=> data integrity violation

