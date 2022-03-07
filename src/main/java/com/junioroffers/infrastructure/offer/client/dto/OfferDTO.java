package com.junioroffers.infrastructure.offer.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OfferDTO {

    private String id;
    private String companyName;
    private String jobPosition;
    private String salary;

}
