package com.junioroffers.offer.domain.dto;

import com.junioroffers.offer.domain.dao.OfferDao;

public interface SampleOfferDaoImpl {

    default OfferDao returnOneOfferDao() {
        return OfferDao.builder()
                .id(1L)
                .companyName("HARMAN Connected Services")
                .jobPosition("Junior Java SE Developer for Automotive")
                .salary("7k - 10k PLN")
                .offerUrl("https://nofluffjobs.com/pl/job/junior-java-se-developer-for-automotive-harman-connected-services-lodz-yafxatha")
                .build();
    }

    default OfferDao returnOneOfferDaoWithoutId() {
        return OfferDao.builder()
                .id(null)
                .companyName("HARMAN Connected Services")
                .jobPosition("Junior Java SE Developer for Automotive")
                .salary("7k - 10k PLN")
                .offerUrl("https://nofluffjobs.com/pl/job/junior-java-se-developer-for-automotive-harman-connected-services-lodz-yafxatha")
                .build();
    }
}
