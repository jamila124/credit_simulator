package com.philips.credit_simulator.util;

import java.time.Year;


// Philippus Muda Sinaga
public class UtilHelper {

    private static final int maxLoanAmount = 1000000000;
    private static final int maxYearsTenor = 6;
    private static final int minYearsTenor = 1;


    public static boolean isValidTenor(int year) {
        if (year >= minYearsTenor && year <= maxYearsTenor) {
            return true;
        }else {
            throw new IllegalArgumentException("Minimal Tenor 1 Sampai 6 Tahun ");
        }
    }

    public static boolean isValidAmount(int amount) {
        if (amount >= 0  && amount <= maxLoanAmount) {
            return true;
        }else {
            throw new IllegalArgumentException("Maksimal Pinjaman di 1 Milyar");
        }
    }

    public static boolean isValidDownPayment(String condition, double totalLoan, double downPayment) {
        double minDP = condition.equalsIgnoreCase("Baru") ? 0.35 * totalLoan : 0.25 * totalLoan;
        if (downPayment >= minDP) {
            return true;
        }else {
            throw new IllegalArgumentException("Downpayment Minimal 25% Untuk Kondisi Bekas dan 35% Untuk Kondisi Baru");
        }
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
            if (year >= currentYear -1) {
                return true;
            }else{
                throw new IllegalArgumentException("Untuk Kondisi Baru Minimal di Tahun : "+String.valueOf(currentYear-1));
            }
        }
        return year > 1999 && year <= currentYear;
    }

    public static boolean isValidYear(int year) {
        int currentYear = Year.now().getValue();
        if (String.valueOf(year).length() == 4){
            return year >= 1999 && year <= currentYear;
        }else {
            throw new IllegalArgumentException("Tahun Kendaraan Harus Numeric Dengan 4 Digit, dan Dari Tahun 1999 sampai Saat ini");
        }
    }


}
