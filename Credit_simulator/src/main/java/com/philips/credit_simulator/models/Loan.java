package com.philips.credit_simulator.models;

import java.util.ArrayList;
import java.util.List;


// Philippus Muda Sinaga
public abstract class Loan {
    protected double totalLoan;
    protected int tenor;
    protected double downPayment;
    protected List<Double> interestRate;

    public abstract double getBaseRate();

    public Loan(double totalLoan, int tenor, double downPayment) {
        this.totalLoan = totalLoan;
        this.tenor = tenor;
        this.downPayment = downPayment;
        interestRate = calculateInterestRate(tenor);
    }

    private List<Double> calculateInterestRate(int tenor) {
        double baseRate = getBaseRate();
        List<Double> interestRate = new ArrayList<>();
        interestRate.add(baseRate);
        for(int year = 2; year <= tenor; year++) {
            if ((year -1 ) % 2 == 0){
                interestRate.add(baseRate += 0.5);
            }else {
                interestRate.add(baseRate += 0.1);
            }
        }
        return interestRate;
    }

    public double calculateMonthlyInstallment() {
        double loanAmount = totalLoan - downPayment;
        double tenorTemp = tenor;
        double installmentMounthlyAvg = 0;
        double installmentMounthly;
        double installmentYearly = 0;
        for (Double rate : interestRate) {
            loanAmount = loanAmount - installmentYearly;
            loanAmount = loanAmount + (loanAmount * (rate/ 100));
            installmentMounthly = loanAmount / (tenorTemp * 12);
            installmentYearly = installmentMounthly * 12;
            installmentMounthlyAvg = installmentMounthlyAvg + installmentYearly;
            --tenorTemp;
        }
        return installmentMounthlyAvg / (tenor * 12);
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public int getTenor() {
        return tenor;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public List<Double> getInterestRate() {
        return interestRate;
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
