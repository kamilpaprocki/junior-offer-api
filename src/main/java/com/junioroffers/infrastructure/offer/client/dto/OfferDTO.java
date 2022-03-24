package com.junioroffers.infrastructure.offer.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OfferDTO {

    @JsonIgnore
    private String id;
    @JsonProperty("company")
    private String companyName;
    @JsonProperty("title")
    private String jobPosition;
    @JsonProperty("salary")
    private String salary;
    @JsonProperty("offerUrl")
    private String offerUrl;
}
