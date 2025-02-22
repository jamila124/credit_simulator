package com.philips.credit_simulator.models;

public abstract class Loan {
    protected double totalLoan;
    protected int tenor;
    protected double downPayment;
    protected double interestRate;


    public abstract double getBaseRate();

    public Loan(double totalLoan, int tenor, double downPayment) {
        this.totalLoan = totalLoan;
        this.tenor = tenor;
        this.downPayment = downPayment;
        this.interestRate = calculateInterestRate(tenor);
    }

    private double calculateInterestRate(int tenor) {
        double baseRate = getBaseRate();
        for(int year = 2; year <= tenor; year++) {
            if ((year -1 ) % 2 == 0){
                baseRate += 0.5;
            }else {
                baseRate += 0.1;
            }
        }
        return baseRate;
    }

    public double monthlyInstallment() {
        double loanAmount = totalLoan - downPayment;
        double monthlyRate = (interestRate / 100) / 12; // Convert annual interest rate to monthly
        int totalMonths = tenor * 12;

        return (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, totalMonths))
                / (Math.pow(1 + monthlyRate, totalMonths) - 1);
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "totalLoan=" + totalLoan +
                ", tenor=" + tenor +
                ", downPayment=" + downPayment +
                ", interestRate=" + interestRate +
                '}';
    }
}
