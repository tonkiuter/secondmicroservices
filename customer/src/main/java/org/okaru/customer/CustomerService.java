package org.okaru.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import jakarta.inject.Inject;

//@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;
    @Inject
    RestTemplate restTemplate;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        repository.saveAndFlush(customer);
        // todo: check if is a fraud

        FraudResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudResponse.class,
                customer.getId()
        );
        if(fraudCheckResponse.getFraudster()){
            throw new IllegalStateException("fraudster!!!");
        }

    }
}
