package com.junioroffers.config;

import com.junioroffers.infrastructure.offer.client.RestClient;
import com.junioroffers.offer.domain.OfferMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JobOffersConfig {

    private final String getOfferUrlEndpoint = "/offers";

    @Bean
    protected OfferUrlConfig offerUrlConfigImpl() {
        return new OfferUrlConfig();
    }

    @Bean
    protected RestTemplate restTemplateImpl() {
        return new RestTemplate();
    }

    @Bean
    protected RestClient restClientImpl() {
        return new RestClient(offerUrlConfigImpl().getUrl() + getOfferUrlEndpoint, restTemplateImpl());
    }

    @Bean
    protected OfferMapper offerMapperImpl() {
        return new OfferMapper();
    }
}
