package com.philips.credit_simulator.dto.request;

public class RequestBody {
    private String vehicleType;
    private String vehicleCondition;
    private int vehicleYear;
    public Integer totalLoan;
    public Integer tenorLoan;
    public Integer totalDownPayment;

    public RequestBody(String vehicleType, String vehicleCondition, int vehicleYear, Integer totalLoan, Integer tenorLoan, Integer totalDownPayment) {
        this.vehicleType = vehicleType;
        this.vehicleCondition = vehicleCondition;
        this.vehicleYear = vehicleYear;
        this.totalLoan = totalLoan;
        this.tenorLoan = tenorLoan;
        this.totalDownPayment = totalDownPayment;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(String vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public Integer getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(Integer totalLoan) {
        this.totalLoan = totalLoan;
    }

    public Integer getTenorLoan() {
        return tenorLoan;
    }

    public void setTenorLoan(Integer tenorLoan) {
        this.tenorLoan = tenorLoan;
    }

    public Integer getTotalDownPayment() {
        return totalDownPayment;
    }

    public void setTotalDownPayment(Integer totalDownPayment) {
        this.totalDownPayment = totalDownPayment;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "vehicleType='" + vehicleType + '\'' +
                ", vehicleCondition='" + vehicleCondition + '\'' +
                ", vehicleYear='" + vehicleYear + '\'' +
                ", totalLoan=" + totalLoan +
                ", tenorLoan=" + tenorLoan +
                ", totalDownPayment=" + totalDownPayment +
                '}';
    }
}
