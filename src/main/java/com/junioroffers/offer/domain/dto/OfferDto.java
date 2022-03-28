package com.junioroffers.offer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class OfferDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("jobPosition")
    private String jobPosition;
    @JsonProperty("salary")
    private String salary;
    @JsonProperty("offerUrl")
    private String offerUrl;
}
