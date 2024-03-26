package com.neoflex.calculatorVacation.controller;

import com.neoflex.calculatorVacation.service.impl.VacationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * VacationController handles vacation-related calculations.
 *
 * @author razlivinsky
 * @since 25.03.2024
 */
@RestController
@RequiredArgsConstructor
public class VacationController {
    private final VacationServiceImpl service;

    /**
     * Calculate vacation pay based on the provided parameters.
     *
     * @param salary the salary of the individual
     * @param vacationDays the number of vacation days requested
     * @param startVacation optional start date of the vacation
     * @param endVacation optional end date of the vacation
     * @return the calculated vacation pay as a double value
     */
    @GetMapping("/calculacte")
    public double calculateVacationPay(
            @RequestParam String salary,
            @RequestParam String vacationDays,
            @RequestParam(required = false) String startVacation,
            @RequestParam(required = false) String endVacation) {
        if (startVacation != null && endVacation != null) {
            return service.calculateVacationPayWithHolidays(salary, vacationDays, startVacation, endVacation);
        } else {
            return service.calculateVacationPay(salary, vacationDays);
        }
    }
}

