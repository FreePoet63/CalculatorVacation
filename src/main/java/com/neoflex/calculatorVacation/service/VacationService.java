package com.neoflex.calculatorVacation.service;

public interface VacationService {
    double calculateVacationPay(String salary, String vacationDays);
    double calculateVacationPayWithHolidays(String salary, String vacationDays, String startVacation, String endVacation);
}
