package com.neoflex.calculatorVacation.validate;

import java.time.LocalDate;

/**
 * The interface ValidateDataVacation provides methods for validating and correcting vacation-related data.
 *
 * @author razlivinsky
 * @since 13.03.2024
 */
public interface ValidateDataVacation {

    /**
     * Corrects and validates the provided salary value.
     *
     * @param salary the salary to be validated
     * @return the corrected salary as a double
     */
    double correctValueSalary(String salary);

    /**
     * Corrects and validates the provided vacation days value.
     *
     * @param vacationDays the vacation days to be validated
     * @return the corrected vacation days as an integer
     */
    int correctValueVacationDays(String vacationDays);

    /**
     * Corrects and validates the provided date value.
     *
     * @param date the date to be validated
     * @return the corrected date as a LocalDate object
     */
    LocalDate correctValueDate(String date);
}
