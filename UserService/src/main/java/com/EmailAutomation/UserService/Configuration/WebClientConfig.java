package com.EmailAutomation.UserService.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient EmailClient() {
        return WebClient.
                builder()
                .baseUrl("lb://EMAIL")
                .build();
    }

    @Bean
    @LoadBalanced
    public WebClient AI_genClient() {
        return WebClient
                .builder()
                .baseUrl("lb://AI")
                .build();
    }
}
