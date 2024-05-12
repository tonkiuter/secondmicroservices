package org.okaru.fraud;

public class FraudResponse {
    Boolean isFraudster;
    public FraudResponse() {

    }
    public FraudResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
    public Boolean getFraudster() {
        return isFraudster;
    }
    public void setFraudster(Boolean fraudster) {
        isFraudster = fraudster;
    }

}
