package com.neoflex.calculatorVacation.service;

/**
 * The interface VacationService defines methods for calculating vacation pay.
 *
 * @author razlivinsky
 * @since 13.03.2024
 */
public interface VacationService {

    /**
     * Calculates the vacation pay based on the salary and number of vacation days provided.
     *
     * @param salary the salary of the individual
     * @param vacationDays the number of vacation days taken
     * @return the calculated vacation pay as a double
     */
    double calculateVacationPay(String salary, String vacationDays);

    /**
     * Calculates the vacation pay including holidays based on the salary, vacation days, start date, and end date provided.
     *
     * @param salary the salary of the individual
     * @param vacationDays the number of vacation days taken
     * @param startVacation the start date of the vacation
     * @param endVacation the end date of the vacation
     * @return the calculated vacation pay as a double
     */
    double calculateVacationPayWithHolidays(String salary, String vacationDays, String startVacation, String endVacation);
}
