package com.junioroffers.infrastructure.offer.client;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JobOfferTestConfig {

    private RestClient restClient(String uri){
        return new RestClient(uri);
    }

    public OfferClient remoteOfferClientTest(String uri){
        return new OfferClient(restClient(uri));
    }




}
