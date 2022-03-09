package com.junioroffers.infrastructure.offer.client.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class OfferDTO {

    private String id;
    private String companyName;
    private String jobPosition;
    private String salary;
    private String offerUrl;

}
