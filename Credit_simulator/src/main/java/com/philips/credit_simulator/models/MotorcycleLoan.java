package com.philips.credit_simulator.models;



// Philippus Muda Sinaga
public class MotorcycleLoan extends Loan{

    private final double baseRate = 9.0;

    public MotorcycleLoan(double totalLoan, int tenor, double downPayment) {
        super(totalLoan, tenor, downPayment);
    }

    @Override
    public double getBaseRate() {
        return baseRate;
    }
}
