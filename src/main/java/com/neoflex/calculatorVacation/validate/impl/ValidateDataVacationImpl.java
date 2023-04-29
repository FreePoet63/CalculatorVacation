package com.neoflex.calculatorVacation.validate.impl;

import com.neoflex.calculatorVacation.exception.IncorrectValueException;
import com.neoflex.calculatorVacation.validate.ValidateDataVacation;

import java.time.LocalDate;
import java.time.format.*;

public class ValidateDataVacationImpl implements ValidateDataVacation {
    @Override
    public double correctValueSalary(String salary) {
        double value = 0.0;
        try {
            value = Double.parseDouble(salary);
            if (value <= 0) {
                throw new IncorrectValueException();
            }
        }catch (Exception e) {
            throw new IncorrectValueException();
        }
        return value;
    }

    @Override
    public int correctValueVacationDays(String vacationDays) {
        int value = 0;
        try {
            value = Integer.parseInt(vacationDays);
            if (value <= 0) {
                throw new IncorrectValueException();
            }
        }catch (Exception e) {
            throw new IncorrectValueException();
        }
        return value;
    }

    @Override
    public LocalDate correctValueDate(String date) {
        LocalDate value = null;
        try {
            value = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            throw new IncorrectValueException();
        }
        return value;
    }
}
