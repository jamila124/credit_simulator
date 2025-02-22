package com.philips.credit_simulator.util;

import java.time.Year;

public class UtilHelper {

    private static final int maxLoanAmount = 1000000000;
    private static final int maxYearsTenor = 6;
    private static final int minYearsTenor = 1;


    public static boolean isValidTenor(int year) {
        return year >= minYearsTenor && year <= maxYearsTenor;
    }

    public static boolean isValidAmount(int amount) {
        return amount >= 0 && amount <= maxLoanAmount;
    }

    public static boolean isValidDownPayment(String condition, double totalLoan, double downPayment) {
        double minDP = condition.equalsIgnoreCase("Baru") ? 0.35 * totalLoan : 0.25 * totalLoan;
        return downPayment >= minDP;
    }

    public static boolean isValidVehicleType(String type){
        return type.equalsIgnoreCase("Motor") || type.equalsIgnoreCase("Mobil");
    }

    public static boolean isValidVehicleCondition(String condition) {
        return condition.equalsIgnoreCase("Baru") || condition.equalsIgnoreCase("Bekas");
    }

    public static boolean isValidVehicleYearByCondition(String condition,int year) {
        int currentYear = Year.now().getValue();
        if (condition.equalsIgnoreCase("Baru")) {
            return year>= (currentYear -1);
        }
        return year > 1999 && year <= currentYear;
    }

    public static boolean isValidYear(int year) {
        int currentYear = Year.now().getValue();
        if (String.valueOf(year).length() == 4){
            return year >= 1999 && year <= currentYear;
        }else {
            return false;
        }
    }


}
