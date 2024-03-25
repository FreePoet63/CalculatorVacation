package com.neoflex.calculatorVacation.util;

/**
 * The DataResultController class provides methods for retrieving specific types of data related to vacation calculations from the controller resource bundle.
 *
 * @author razlivinsky
 * @since 25.03.2024
 */
public class DataResultController {
    private static final String SALARY = "salary";
    private static final String VACATION_DAYS = "vacationDays";
    private static final String START_VACATION = "startVacation";
    private static final String END_VACATION = "endVacation";
    private static final String EXPECTED_VACATION_PAY = "expectedVacationPay";

    /**
     * Retrieves the salary from the controller resource bundle.
     *
     * @return the salary retrieved from the controller resource bundle
     */
    public static String getSalary() {
        return DataReader.getControllerTest(SALARY);
    }

    /**
     * Retrieves the vacation days from the controller resource bundle.
     *
     * @return the vacation days retrieved from the controller resource bundle
     */
    public static String getVacationDays() {
        return DataReader.getControllerTest(VACATION_DAYS);
    }

    /**
     * Retrieves the start vacation date from the controller resource bundle.
     *
     * @return the start vacation date retrieved from the controller resource bundle
     */
    public static String getStartVacation() {
        return DataReader.getControllerTest(START_VACATION);
    }

    /**
     * Retrieves the end vacation date from the controller resource bundle.
     *
     * @return the end vacation date retrieved from the controller resource bundle
     */
    public static String getEndVacation() {
        return DataReader.getControllerTest(END_VACATION);
    }

    /**
     * Retrieves the expected vacation pay from the controller resource bundle.
     *
     * @return the expected vacation pay retrieved from the controller resource bundle
     */
    public static String getExpectedVacationPay() {
        return DataReader.getControllerTest(EXPECTED_VACATION_PAY);
    }
}
