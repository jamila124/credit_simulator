package com.philips.credit_simulator.dto.request;

public class RequestBody {
    private String vehicleType;
    private String vehicleCondition;
    private String vehicleYear;
    public Integer totalLoan;
    public Integer tenorLoan;
    public Integer totalDownPayment;

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

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
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
