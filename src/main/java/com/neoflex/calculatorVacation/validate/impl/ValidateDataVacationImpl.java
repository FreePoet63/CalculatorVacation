package com.neoflex.calculatorVacation.validate.impl;

import com.neoflex.calculatorVacation.exception.IncorrectValueException;
import com.neoflex.calculatorVacation.validate.ValidateDataVacation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.neoflex.calculatorVacation.logger.Log.error;

/**
 * The class ValidateDataVacationImpl provides methods for validating and correcting vacation-related data.
 *
 * @author razlivinsky
 * @since 13.03.2024
 */
public class ValidateDataVacationImpl implements ValidateDataVacation {

    /**
     * Corrects and validates the provided salary value.
     *
     * @param salary the salary to be validated
     * @return the corrected salary as a double
     * @throws IncorrectValueException if the provided value is less than or equal to zero
     */
    @Override
    public double correctValueSalary(String salary) {
        double value = 0.0;
        try {
            value = Double.parseDouble(salary);
            if (value <= 0) {
                error("Invalid input data: negative or zero salary");
                throw new IncorrectValueException("Negative or zero salary: " + value);
            }
        }catch (Exception e) {
            error("Error during salary value parsing");
            throw new IncorrectValueException("Error during salary value parsing");
        }
        return value;
    }

    /**
     * Corrects and validates the provided vacation days value.
     *
     * @param vacationDays the vacation days to be validated
     * @return the vacation days as an integer
     * @throws IncorrectValueException if the provided value is less than or equal to zero
     */
    @Override
    public int correctValueVacationDays(String vacationDays) {
        int value = 0;
        try {
            value = Integer.parseInt(vacationDays);
            if (value <= 0) {
                error("Invalid input data: negative or zero vacation days");
                throw new IncorrectValueException("Negative or zero vacation days: " + value);
            }
        }catch (Exception e) {
            error("Error during vacation days value parsing");
            throw new IncorrectValueException("Error during vacation days value parsing");
        }
        return value;
    }

    /**
     * Corrects and validates the provided date value.
     *
     * @param date the date to be validated in the format "yyyy-MM-dd"
     * @return the corrected date as a LocalDate object
     * @throws IncorrectValueException if the provided date is in an incorrect format
     */
    @Override
    public LocalDate correctValueDate(String date) {
        LocalDate value = null;
        try {
            value = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            error("Invalid input data: incorrect date format");
            throw new IncorrectValueException("Incorrect date format: " + date);
        }
        return value;
    }
}
