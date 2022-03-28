package com.junioroffers.offer.domain;

import com.junioroffers.infrastructure.offer.client.dto.OfferDto;

public class OfferMapper {

    public OfferDto mapToOfferDto(String companyName, String position, String salary, String offerUrl) {
        return OfferDto.builder()
                .companyName(companyName)
                .jobPosition(position)
                .salary(salary)
                .offerUrl(offerUrl)
                .build();
    }
}
