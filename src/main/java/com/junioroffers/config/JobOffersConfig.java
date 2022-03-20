package com.junioroffers.config;

import com.junioroffers.infrastructure.offer.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobOffersConfig {

    private final static String OFFER_URL = "http://programming-masterpiece.com:5057/offers";

    @Bean
    protected RestClient restClientImpl(){
        return new RestClient(OFFER_URL);
    }
}
