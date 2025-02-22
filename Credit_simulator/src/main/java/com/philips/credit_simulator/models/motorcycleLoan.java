package com.philips.credit_simulator.models;

public class motorcycleLoan extends Loan{

    private final double baseRate = 9.0;

    public motorcycleLoan(double totalLoan, int tenor, double downPayment) {
        super(totalLoan, tenor, downPayment);
    }

    @Override
    public double getBaseRate() {
        return baseRate;
    }
}
