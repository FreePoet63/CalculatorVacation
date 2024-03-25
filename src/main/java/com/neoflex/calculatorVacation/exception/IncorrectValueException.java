package com.neoflex.calculatorVacation.exception;

/**
 * The type Incorrect value exception represents an exception to be thrown when an incorrect value is encountered.
 *
 * @author razlivinsky
 * @since 25.03.2024
 */
public class IncorrectValueException extends RuntimeException{

    /**
     * Instantiates a new Incorrect value exception with a provided message.
     *
     * @param message the message explaining the incorrect value exception
     */
    public IncorrectValueException(String message) {
        super(message);
    }
}
