package com.junioroffers.offer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OfferDto {

    @JsonProperty(value = "companyName")
    private String companyName;
    @JsonProperty(value = "jobPosition")
    private String jobPosition;
    @JsonProperty(value = "salary")
    private String salary;
    @JsonProperty(value = "offerUrl")
    private String offerUrl;
}
