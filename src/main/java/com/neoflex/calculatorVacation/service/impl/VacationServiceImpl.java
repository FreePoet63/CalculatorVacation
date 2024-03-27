package com.neoflex.calculatorVacation.service.impl;

import com.neoflex.calculatorVacation.service.VacationService;
import com.neoflex.calculatorVacation.validate.ValidateDataVacation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.neoflex.calculatorVacation.logger.Log.info;

/**
 * The class VacationServiceImpl provides methods for calculating vacation pay and handling vacation periods.
 *
 * @author razlivinsky
 * @since 13.03.2024
 */
@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {
    private final ValidateDataVacation validateDataVacation;
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

    /**
     * Calculates the standard vacation pay based on the provided salary and number of vacation days.
     *
     * @param salary the salary of the individual
     * @param vacationDays the number of vacation days taken
     * @return the calculated vacation pay as a double
     */
    @Override
    public double calculateVacationPay(String salary, String vacationDays) {
        double newSalary = validateDataVacation.correctValueSalary(salary);
        int newVacationDays = validateDataVacation.correctValueVacationDays(vacationDays);
        double resultVacationPay = newSalary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * newVacationDays;
        resultVacationPay = ((int) (resultVacationPay * 100)) / 100;
        return resultVacationPay;
    }

    /**
     * Calculates the vacation pay including holidays based on the salary, vacation days, start date, and end date provided.
     *
     * @param salary the salary of the individual
     * @param vacationDays the number of vacation days taken
     * @param startVacation the start date of the vacation
     * @param endVacation the end date of the vacation
     * @return the calculated vacation pay as a double including holidays
     */
    @Override
    public double calculateVacationPayWithHolidays(
            String salary,
            String vacationDays,
            String startVacation,
            String endVacation
    ) {
        double newSalary = validateDataVacation.correctValueSalary(salary);
        validateDataVacation.correctValueVacationDays(vacationDays);
        LocalDate startDate = validateDataVacation.correctValueDate(startVacation);
        LocalDate endDate = validateDataVacation.correctValueDate(endVacation);

        List<LocalDate> vacationDaysList = startDate.datesUntil(endDate.plusDays(1)).collect(Collectors.toList());
        long holidayCount = HOLIDAYS.stream().filter(vacationDaysList::contains).count();

        endDate = endDate.plusDays(holidayCount);

        long newVacationDaysCount = startDate.until(endDate, ChronoUnit.DAYS);

        double pay = newSalary / THE_AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH * newVacationDaysCount;
        pay = ((int) (pay * 100)) / 100;

        info("Отпуск продлен на " + holidayCount + " дней из-за праздников.");
        return pay;
    }
}
