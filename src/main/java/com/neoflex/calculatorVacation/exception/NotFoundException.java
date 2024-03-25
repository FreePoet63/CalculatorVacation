package com.neoflex.calculatorVacation.exception;

/**
 * The NotFoundException class represents an exception to be thrown when a resource is not found.
 *
 * @author Razlivinsky
 * @since 25.03.2024
 */
public class NotFoundException extends RuntimeException{

    /**
     * Instantiates a new NotFoundException with a given message.
     *
     * @param message the message explaining the reason for the resource not being found
     */
    public NotFoundException(String message) {
        super(message);
    }
}