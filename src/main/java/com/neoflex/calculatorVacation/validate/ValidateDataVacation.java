package com.neoflex.calculatorVacation.validate;

import java.time.LocalDate;

public interface ValidateDataVacation {
    double correctValueSalary(String salary);
    int correctValueVacationDays(String vacationDays);
    LocalDate correctValueDate(String date);

}
