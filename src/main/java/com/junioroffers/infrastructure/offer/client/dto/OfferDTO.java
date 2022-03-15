package com.junioroffers.infrastructure.offer.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class OfferDTO {

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
