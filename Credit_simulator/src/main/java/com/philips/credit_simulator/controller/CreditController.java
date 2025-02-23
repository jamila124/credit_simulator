package com.philips.credit_simulator.controller;

import com.philips.credit_simulator.dto.response.ResponseBody;
import com.philips.credit_simulator.service.CreditSimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    CreditSimulatorService creditSimulatorService;

    public ResponseEntity<ResponseBody> calculateInstallment(@RequestBody com.philips.credit_simulator.dto.request.RequestBody requestBody){
        return ResponseEntity.ok().body(creditSimulatorService.creditSimulator(requestBody));
    }
}
