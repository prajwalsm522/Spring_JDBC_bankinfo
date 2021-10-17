package com.SpringDemo.bank.Controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuration {

    @Bean
    public bank bank(){
        return new bank();
    }

}
