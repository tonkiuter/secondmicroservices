package org.okaru.customer;


import lombok.extern.slf4j.Slf4j;
import org.okaru.clients.fraud.FraudClient;
import org.okaru.clients.fraud.FraudResponse;
import org.okaru.clients.notification.NotificationClient;
import org.okaru.clients.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import jakarta.inject.Inject;

//@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository repository;

//    @Inject
//    RestTemplate restTemplate;

    @Inject
    FraudClient fraudClient;

    @Inject
    NotificationClient notificationClient;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        repository.saveAndFlush(customer);
        // todo: check if is a fraud

//        FraudResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudResponse.class,
//                customer.getId()
//        );

        log.info("Before FraudResponse:");
        FraudResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());


        if(fraudCheckResponse.getFraudster()){
            throw new IllegalStateException("fraudster!!!");
        }
        else {
//            NotificationRequest notificationRequest = new NotificationRequest(customer.getId(),
//                    customerRequest.getEmail(), "Is not Fraud!", customerRequest.getFirstName());
//            restTemplate.postForEntity("http://NOTIFICATION/api/v1/notification", notificationRequest, NotificationRequest.class);
            log.info("Before NotificationRequest:");
            NotificationRequest notificationRequest = new NotificationRequest(customer.getId(),
                    customerRequest.getEmail(), "Is not Fraud!", customerRequest.getFirstName());
            notificationClient.sendNotification(notificationRequest);
        }
    }
}
