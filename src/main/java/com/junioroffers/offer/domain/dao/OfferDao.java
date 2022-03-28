package com.junioroffers.offer.domain.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfferDao {

    private Long id;
    private String companyName;
    private String jobPosition;
    private String salary;
    private String offerUrl;
}
