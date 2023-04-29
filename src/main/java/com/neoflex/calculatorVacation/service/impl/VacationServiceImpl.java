package com.neoflex.calculatorVacation.service.impl;

import com.neoflex.calculatorVacation.service.VacationService;
import com.neoflex.calculatorVacation.validate.impl.ValidateDataVacationImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class VacationServiceImpl implements VacationService {
    private static final double THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH = 29.3;

    private static final List<LocalDate> HOLIDAYS = Arrays.asList(
            LocalDate.of(LocalDate.now().getYear(), 1, 1),
            LocalDate.of(LocalDate.now().getYear(), 1, 2),
            LocalDate.of(LocalDate.now().getYear(), 1, 3),
            LocalDate.of(LocalDate.now().getYear(), 1, 4),
            LocalDate.of(LocalDate.now().getYear(), 1, 5),
            LocalDate.of(LocalDate.now().getYear(), 1, 6),
            LocalDate.of(LocalDate.now().getYear(), 1, 7),
            LocalDate.of(LocalDate.now().getYear(), 2, 23),
            LocalDate.of(LocalDate.now().getYear(), 3, 8),
            LocalDate.of(LocalDate.now().getYear(), 5, 1),
            LocalDate.of(LocalDate.now().getYear(), 5, 9),
            LocalDate.of(LocalDate.now().getYear(), 6, 12),
            LocalDate.of(LocalDate.now().getYear(), 11, 4),
            LocalDate.of(LocalDate.now().getYear(), 12, 31)
    );

    @Override
    public double calculateVacationPay(String salary, String vacationDays) {
        double newSalary = new ValidateDataVacationImpl().correctValueSalary(salary);
        int newVacationDays = new ValidateDataVacationImpl().correctValueVacationDays(vacationDays);
        double resultVacationPay = newSalary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * newVacationDays;
        resultVacationPay = ((int) (resultVacationPay * 100)) / 100;
        return resultVacationPay;
    }

    @Override
    public double calculateVacationPayWithHolidays(
            String salary,
            String vacationDays,
            String startVacation,
            String endVacation
    ) {
        double newSalary = new ValidateDataVacationImpl().correctValueSalary(salary);
        int newVacationDays = new ValidateDataVacationImpl().correctValueVacationDays(vacationDays);
        double pay = newSalary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * newVacationDays;
        pay =  ((int) (pay * 100)) / 100;
        long holidayCount = HOLIDAYS
                .stream()
                .filter(holiday ->
                        holiday.isAfter(new ValidateDataVacationImpl().correctValueDate(startVacation)) &&
                                holiday.isBefore(new ValidateDataVacationImpl().correctValueDate(endVacation)))
                .count();
        if (holidayCount > 0) {
            System.out.println("Vacation extended by " + holidayCount + " days due to holiday");
        }
        return pay;
    }
}
