package com.neoflex.calculatorVacation.controller;

import com.neoflex.calculatorVacation.exception.ExceptionBody;
import com.neoflex.calculatorVacation.exception.IncorrectValueException;
import com.neoflex.calculatorVacation.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ControllerAdvice class handles global exceptions for the application.
 *
 * @author razlivinsky
 * @since 25.03.2024
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * Handles the IncorrectValueException and returns a BadRequest response.
     *
     * @param e the IncorrectValueException that was thrown
     * @return the response body with the exception message
     */
    @ExceptionHandler(IncorrectValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleIncorrectValue(IncorrectValueException e) {
        return new ExceptionBody(e.getMessage());
    }

    /**
     * Handles the IllegalArgumentException and returns a BadRequest response with a specific message.
     *
     * @param e the IllegalArgumentException that was thrown
     * @return the response body with an error message
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleIllegalArgument(IllegalArgumentException e) {
        return new ExceptionBody("Invalid date comparison: " + e.getMessage());
    }

    /**
     * Handles the NotFoundException and returns a NotFound response.
     *
     * @param e the NotFoundException that was thrown
     * @return the response body with a message indicating the page was not found
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleNotFound(NotFoundException e) {
        return new ExceptionBody("Page not found: " + e.getMessage());
    }

    /**
     * Handles any other Exception and returns an InternalServerError response.
     *
     * @param e the Exception that was thrown
     * @return the response body with a message indicating an internal server error
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleInternalServerError(Exception e) {
        return new ExceptionBody("Internal server error: " + e.getMessage());
    }
}