package com.neoflex.calculatorVacation.service;

import com.neoflex.calculatorVacation.exception.IncorrectValueException;
import com.neoflex.calculatorVacation.service.impl.VacationServiceImpl;
import com.neoflex.calculatorVacation.validate.impl.ValidateDataVacationImpl;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.time.LocalDate;

public class VacationServiceImplTest {
    private static final double THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH = 29.3;

    @Mock
    private ValidateDataVacationImpl validator;

    @InjectMocks
    private VacationServiceImpl service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateVacationPay() {
        double salary = 9000.0;
        int vacationDays = 21;
        double expected = salary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * vacationDays;
        expected = ((int) (expected * 100)) / 100;

        String salaryString = "9000";
        String vacationDaysString = "21";
        double delta = 0.01;

        Mockito.when(validator.correctValueSalary(salaryString)).thenReturn(salary);
        Mockito.when(validator.correctValueVacationDays(vacationDaysString)).thenReturn(vacationDays);

        double result = service.calculateVacationPay(salaryString, vacationDaysString);

        Assertions.assertEquals(expected, result, delta);
    }

    @Test
    public void testCalculateVacationPayWithHolidays() {
        double salary = 9000.0;
        int vacationDays = 21;
        double expected = salary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * vacationDays;
        expected = ((int) (expected * 100)) / 100;

        String salaryString = "9000";
        String vacationDaysString = "21";
        String startVacation = "2021-06-01";
        String endVacation = "2021-06-21";
        double delta = 0.01;

        Mockito.when(validator.correctValueSalary(salaryString)).thenReturn(salary);
        Mockito.when(validator.correctValueVacationDays(vacationDaysString)).thenReturn(vacationDays);
        Mockito.when(validator.correctValueDate(startVacation)).thenReturn(LocalDate.parse(startVacation));
        Mockito.when(validator.correctValueDate(endVacation)).thenReturn(LocalDate.parse(endVacation));

        double result = service.calculateVacationPayWithHolidays(salaryString, vacationDaysString, startVacation, endVacation);

        Assertions.assertEquals(expected, result, delta);
    }

    @Test
    public void testCalculateVacationPayWithNegativeSalary() {
        String salaryString = "-5000";
        String vacationDaysString = "21";

        Mockito.when(validator.correctValueSalary(salaryString))
                .thenThrow(new IncorrectValueException());

        Assertions.assertThrows(IncorrectValueException.class,
                () -> service.calculateVacationPay(salaryString, vacationDaysString));
    }

    @Test
    public void testCalculateVacationPayWithZeroVacationDays() {
        String salaryString = "9000";
        String vacationDaysString = "12";
        String startVacationString = "sos";
        String endVacationString = "2023-07-12";

        Mockito.when(validator.correctValueVacationDays(vacationDaysString))
                .thenThrow(new IncorrectValueException());

        Assertions.assertThrows(IncorrectValueException.class,
                () -> service.calculateVacationPayWithHolidays(salaryString, vacationDaysString, startVacationString, endVacationString));
    }
}

