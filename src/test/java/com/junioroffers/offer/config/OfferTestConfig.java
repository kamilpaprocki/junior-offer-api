package com.junioroffers.offer.config;

import com.junioroffers.offer.domain.OfferMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferTestConfig {

    public OfferMapper offerMapperImpl() {
        return new OfferMapper();
    }
}
