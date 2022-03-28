package com.junioroffers.offer.domain.dao;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class OfferDao {

    private Long id;
    private String companyName;
    private String jobPosition;
    private String salary;
    private String offerUrl;
}
