package org.okaru.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckHistoryService {
    private final FraudCheckRepository fraudCheckRepository;

    public FraudCheckHistoryService(FraudCheckRepository fraudCheckRepository){
        this.fraudCheckRepository = fraudCheckRepository;
    }
    public Boolean isFraudulentCustomer(Integer customerId){
        fraudCheckRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
