package com.neoflex.calculatorVacation.controller;

import com.neoflex.calculatorVacation.service.impl.VacationServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class VacationController {
    private final VacationServiceImpl service;

    public VacationController(VacationServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/calculate")
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

