package com.philips.credit_simulator.factories;

import com.philips.credit_simulator.models.CarLoan;
import com.philips.credit_simulator.models.Loan;
import com.philips.credit_simulator.models.MotorcycleLoan;

public class loanFactory {
    public static Loan loanFactory(String vehicleType,double totalLoan, int tenor, double downPayment) {
        if (vehicleType.equalsIgnoreCase("Mobil")){
            return new CarLoan(totalLoan, tenor, downPayment);
        } else if (vehicleType.equalsIgnoreCase("Motor")) {
            return new MotorcycleLoan(totalLoan, tenor, downPayment);
        }
        throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
    }
}
