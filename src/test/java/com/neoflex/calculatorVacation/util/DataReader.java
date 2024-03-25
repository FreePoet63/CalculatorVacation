package com.neoflex.calculatorVacation.util;

import java.util.ResourceBundle;

/**
 * The DataReader class provides methods for retrieving test strings from resource bundles for testing purposes.
 *
 * @author razlivinsky
 * @since 25.03.2024
 */
public class DataReader {
    private static ResourceBundle resourceBundleControllerTest = ResourceBundle.getBundle("controller");
    private static ResourceBundle resourceBundleServiceTest = ResourceBundle.getBundle("service");

    /**
     * Retrieves the test string from the controller resource bundle based on the provided key.
     *
     * @param key the key to retrieve the test string from the controller resource bundle
     * @return the test string from the controller resource bundle corresponding to the provided key
     */
    public static String getControllerTest(String key){
        return resourceBundleControllerTest.getString(key);
    }

    /**
     * Retrieves the test string from the service resource bundle based on the provided key.
     *
     * @param key the key to retrieve the test string from the service resource bundle
     * @return the test string from the service resource bundle corresponding to the provided key
     */
    public static String getServiceTest(String key){
        return resourceBundleServiceTest.getString(key);
    }
}