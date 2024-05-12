package org.okaru.fraud;

import lombok.extern.slf4j.Slf4j;
import org.okaru.clients.fraud.FraudResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudCheckController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    public FraudCheckController(FraudCheckHistoryService fraudCheckHistoryService) {
        this.fraudCheckHistoryService = fraudCheckHistoryService;
    }

    @GetMapping(path = "{customerId}")
    public FraudResponse isFraudster(@PathVariable("customerId") Integer customerId){
        Boolean isFraudulent =
                fraudCheckHistoryService.isFraudulentCustomer(customerId);

        log.info("Fraud Check Request for customer {} ", customerId);
        return new FraudResponse(isFraudulent);
    }



}
