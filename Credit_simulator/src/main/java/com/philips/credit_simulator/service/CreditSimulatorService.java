package com.philips.credit_simulator.service;

import com.philips.credit_simulator.dto.request.RequestBody;
import com.philips.credit_simulator.dto.response.ResponseBody;
import com.philips.credit_simulator.models.CarLoan;
import com.philips.credit_simulator.models.Loan;
import com.philips.credit_simulator.models.MotorcycleLoan;
import com.philips.credit_simulator.util.UtilHelper;
import org.springframework.stereotype.Service;


// Philippus Muda Sinaga
@Service
public class CreditSimulatorService {

    public ResponseBody creditSimulator(RequestBody requestBody) {
        ResponseBody response = new ResponseBody();
        if (requestBody.getVehicleType().equalsIgnoreCase("Mobil")){
            Loan loan = new CarLoan(requestBody.getTotalLoan(),requestBody.getTenorLoan(),requestBody.getTotalDownPayment());
            if (requestBody.getVehicleCondition().equalsIgnoreCase("Baru")){
                UtilHelper.isValidDownPayment("Baru",requestBody.getTotalLoan(),requestBody.getTotalDownPayment());
                UtilHelper.isValidVehicleYearByCondition("Baru",requestBody.getVehicleYear());
            }else {
                UtilHelper.isValidDownPayment("Bekas",requestBody.getTotalLoan(),requestBody.getTotalDownPayment());
            }
            UtilHelper.isValidTenor(requestBody.getTenorLoan());
            UtilHelper.isValidAmount(requestBody.getTotalLoan());
            UtilHelper.isValidYear(requestBody.getVehicleYear());
            response.setMonthlyInstallment(String.valueOf(loan.calculateMonthlyInstallment()));
        } else if (requestBody.getVehicleType().equalsIgnoreCase("Motor")) {
            Loan loan = new MotorcycleLoan(requestBody.totalLoan, requestBody.getTenorLoan(), requestBody.getTotalDownPayment());
            response.setMonthlyInstallment(String.valueOf(loan.calculateMonthlyInstallment()));
        }
        return response;
    }
}
