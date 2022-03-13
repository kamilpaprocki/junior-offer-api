package com.junioroffers.config;

import com.junioroffers.infrastructure.offer.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobOffersConfig {

    @Bean
    protected RestClient restClientImpl(){
        return new RestClient();
    }
}
