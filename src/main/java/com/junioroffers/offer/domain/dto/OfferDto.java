package com.junioroffers.offer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OfferDto {

    private String companyName;
    private String jobPosition;
    private String salary;
    private String offerUrl;
}
