package com.Hall.Lawn.Booking.System.Api.Configuration;

import com.Hall.Lawn.Booking.System.Api.DTO.ApiResponse;
import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Exception.UnprocessableEntityException;
import com.Hall.Lawn.Booking.System.Api.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<String> handleUnprocessableEntity(UnprocessableEntityException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }

    // @Valid failures on the request body -> 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
        String message = "Validation failed";
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        if (!errors.isEmpty()) {
            FieldError error = errors.get(0);
            message = error.getField() + ": " + error.getDefaultMessage();
        }
        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
//
//    public ResponseEntity<ApiResponse<Booking>> HandleBookingConflict(SlotAlreadyBookedException ex){
//
//    }
}
