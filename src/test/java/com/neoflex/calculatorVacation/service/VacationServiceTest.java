package com.neoflex.calculatorVacation.service;

import com.neoflex.calculatorVacation.exception.IncorrectValueException;
import com.neoflex.calculatorVacation.validate.ValidateDataVacation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static com.neoflex.calculatorVacation.util.DataResultService.*;

@SpringBootTest
public class VacationServiceTest {
    private static final double THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH = 29.3;

    @Autowired
    private VacationService service;

    @MockBean
    private ValidateDataVacation validator;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateVacationPay() {
        double salary = Double.parseDouble(getSalary());
        int vacationDays = Integer.parseInt(getVacationDays());
        double expected = salary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * vacationDays;
        expected = ((int) (expected * 100)) / 100;

        String salaryString = getSalaryString();
        String vacationDaysString = getVacationDaysString();
        double delta = Double.parseDouble(getDelta());

        Mockito.when(validator.correctValueSalary(salaryString)).thenReturn(salary);
        Mockito.when(validator.correctValueVacationDays(vacationDaysString)).thenReturn(vacationDays);

        double result = service.calculateVacationPay(salaryString, vacationDaysString);

        Assertions.assertEquals(expected, result, delta);
    }

    @Test
    public void testCalculateVacationPayWithHolidays() {
        double salary = Double.parseDouble(getSalary());
        int vacationDays = Integer.parseInt(getVacationDaysHoliday());
        double expected = salary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * vacationDays;
        expected = ((int) (expected * 100)) / 100;

        String salaryString = getSalaryString();
        String vacationDaysString = getVacationDaysString();
        String startVacation = getStartVacation();
        String endVacation = getEndVacation();
        double delta = Double.parseDouble(getDelta());

        Mockito.when(validator.correctValueSalary(salaryString)).thenReturn(salary);
        Mockito.when(validator.correctValueVacationDays(vacationDaysString)).thenReturn(vacationDays);
        Mockito.when(validator.correctValueDate(startVacation)).thenReturn(LocalDate.parse(startVacation));
        Mockito.when(validator.correctValueDate(endVacation)).thenReturn(LocalDate.parse(endVacation));

        double result = service.calculateVacationPayWithHolidays(salaryString, vacationDaysString, startVacation, endVacation);

        Assertions.assertEquals(expected, result, delta);
    }

    @Test
    public void testCalculateVacationPayWithNegativeSalary() {
        String salaryString = getSalaryNegativeString();
        String vacationDaysString = getVacationDaysString();

        Mockito.when(validator.correctValueSalary(salaryString))
                .thenThrow(new IncorrectValueException("Incorrect value"));

        Assertions.assertThrows(IncorrectValueException.class,
                () -> service.calculateVacationPay(salaryString, vacationDaysString));
    }

    @Test
    public void testCalculateVacationPayWithZeroVacationDays() {
        String salaryString = getSalaryString();
        String vacationDaysString = getVacationDaysString();
        String startVacationString = getStartVacationStringError();
        String endVacationString = getEndVacation();

        Mockito.when(validator.correctValueVacationDays(vacationDaysString))
                .thenThrow(new IncorrectValueException("Incorrect value"));

        Assertions.assertThrows(IncorrectValueException.class,
                () -> service.calculateVacationPayWithHolidays(salaryString, vacationDaysString, startVacationString, endVacationString));
    }
}

