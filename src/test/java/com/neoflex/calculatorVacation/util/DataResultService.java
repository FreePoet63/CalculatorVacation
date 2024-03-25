package com.neoflex.calculatorVacation.util;

/**
 * The DataResultService class provides methods for retrieving specific types of data related to vacation calculations from the service resource bundle.
 *
 * @author razlivinsky
 * @since 25.03.2024
 */
public class DataResultService {
    private static final String SALARY = "salary";
    private static final String VACATION_DAYS = "vacationDays";
    private static final String START_VACATION = "startVacation";
    private static final String END_VACATION = "endVacation";
    private static final String VACATION_DAYS_HOLIDAY = "vacationDaysHoliday";
    private static final String VACATION_DAYS_STRING = "vacationDaysString";
    private static final String SALARY_STRING = "salaryString";
    private static final String DELTA = "delta";
    private static final String SALARY_NEGATIVE_STRING = "salaryNegativeString";
    private static final String START_VACATION_STRING_ERROR = "startVacationStringError";

    /**
     * Retrieves the salary from the service resource bundle.
     *
     * @return the salary retrieved from the service resource bundle
     */
    public static String getSalary() {
        return DataReader.getServiceTest(SALARY);
    }

    /**
     * Retrieves the vacation days from the service resource bundle.
     *
     * @return the vacation days retrieved from the service resource bundle
     */
    public static String getVacationDays() {
        return DataReader.getServiceTest(VACATION_DAYS);
    }

    /**
     * Retrieves the start vacation from the service resource bundle.
     *
     * @return the start vacation retrieved from the service resource bundle
     */
    public static String getStartVacation() {
        return DataReader.getServiceTest(START_VACATION);
    }

    /**
     * Retrieves the end vacation from the service resource bundle.
     *
     * @return the end vacation retrieved from the service resource bundle
     */
    public static String getEndVacation() {
        return DataReader.getServiceTest(END_VACATION);
    }

    /**
     * Retrieves the vacation days holiday from the service resource bundle.
     *
     * @return the vacation days holiday retrieved from the service resource bundle
     */
    public static String getVacationDaysHoliday() {
        return DataReader.getServiceTest(VACATION_DAYS_HOLIDAY);
    }

    /**
     * Retrieves the vacation days string from the service resource bundle.
     *
     * @return the vacation days string retrieved from the service resource bundle
     */
    public static String getVacationDaysString() {
        return DataReader.getServiceTest(VACATION_DAYS_STRING);
    }

    /**
     * Retrieves the salary string from the service resource bundle.
     *
     * @return the salary string retrieved from the service resource bundle
     */
    public static String getSalaryString() {
        return DataReader.getServiceTest(SALARY_STRING);
    }

    /**
     * Retrieves the delta from the service resource bundle.
     *
     * @return the delta retrieved from the service resource bundle
     */
    public static String getDelta() {
        return DataReader.getServiceTest(DELTA);
    }

    /**
     * Retrieves the salary negative string from the service resource bundle.
     *
     * @return the salary negative string retrieved from the service resource bundle
     */
    public static String getSalaryNegativeString() {
        return DataReader.getServiceTest(SALARY_NEGATIVE_STRING);
    }

    /**
     * Retrieves the start vacation string error from the service resource bundle.
     *
     * @return the start vacation string error retrieved from the service resource bundle
     */
    public static String getStartVacationStringError() {
        return DataReader.getServiceTest(START_VACATION_STRING_ERROR);
    }
}