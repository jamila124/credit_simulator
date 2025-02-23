package com.philips.credit_simulator.models;



// Philippus Muda Sinaga
public class CarLoan extends Loan{

    private final double baseRate = 8.0;

    public CarLoan(double totalLoan, int tenor, double downPayment) {
        super(totalLoan, tenor, downPayment);
    }

    @Override
    public double getBaseRate() {
        return baseRate;
    }
}
