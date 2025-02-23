package com.philips.credit_simulator;

import com.philips.credit_simulator.dto.request.RequestBody;
import com.philips.credit_simulator.dto.response.ResponseBody;
import com.philips.credit_simulator.service.CreditSimulatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoanServiceTest {
    @InjectMocks
    private CreditSimulatorService creditSimulatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreditSimulator_CarLoanBekas() {
        RequestBody request = new RequestBody("Mobil", "Bekas", 2024,100000000,3, 25000000);
        ResponseBody response = creditSimulatorService.creditSimulator(request);
        assertNotNull(response);
        assertNotNull(response.getMonthlyInstallment());
        assertEquals("2441224.5", response.getMonthlyInstallment()); // Replace with actual expected value
    }

    @Test
    public void testCreditSimulator_CarLoanBaru() {
        RequestBody request = new RequestBody("Mobil", "Baru", 2024,100000000,3, 35000000);
        ResponseBody response = creditSimulatorService.creditSimulator(request);
        assertNotNull(response);
        assertNotNull(response.getMonthlyInstallment());
        assertEquals("2115727.9000000004", response.getMonthlyInstallment()); // Replace with actual expected value
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditSimulator_InvalidDwonPaymentBekas() {
        RequestBody request = new RequestBody("Mobil", "Bekas", 2024,100000000,3, 20000000);
        creditSimulatorService.creditSimulator(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditSimulator_InvalidDwonPaymentBaru() {
        RequestBody request = new RequestBody("Mobil", "Baru", 2024,100000000,3, 20000000);
        creditSimulatorService.creditSimulator(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditSimulator_InvalidYearKendaraanBaru() {
        RequestBody request = new RequestBody("Mobil", "Baru", 2020,100000000,3, 40000000);
        creditSimulatorService.creditSimulator(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditSimulator_InvalidYearDigit() {
        RequestBody request = new RequestBody("Mobil", "Baru", 202,100000000,3, 40000000);
        creditSimulatorService.creditSimulator(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditSimulator_InvalidTenorYear() {
        RequestBody request = new RequestBody("Mobil", "Bekas", 2020,100000000,7, 40000000);
        creditSimulatorService.creditSimulator(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditSimulator_InvalidTotalLoan() {
        RequestBody request = new RequestBody("Mobil", "Bekas", 2020,1100000000,7, 40000000);
        creditSimulatorService.creditSimulator(request);
    }

}
