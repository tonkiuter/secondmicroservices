package org.okaru.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CustomerService customerService(){
        return new CustomerService();
    }

}
