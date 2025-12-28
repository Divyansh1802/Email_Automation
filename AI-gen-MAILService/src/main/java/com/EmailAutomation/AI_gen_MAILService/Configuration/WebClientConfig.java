package com.EmailAutomation.AI_gen_MAILService.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient AiPromptClient(){
        return WebClient
                .builder()
                .build();
    }

    @Bean
    @LoadBalanced
    public WebClient EmailClient(){
        return WebClient
                .builder()
                .baseUrl("lb://EMAIL")
                .build();
    }
}
