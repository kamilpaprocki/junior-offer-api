package com.junioroffers.offer.domain;

import com.junioroffers.offer.domain.dao.OfferDao;
import com.junioroffers.offer.domain.dto.OfferDto;

public class OfferMapper {

    public OfferDto mapToOfferDto(OfferDao offerDao) {
        return OfferDto.builder()
                .id(offerDao.getId())
                .companyName(offerDao.getCompanyName())
                .jobPosition(offerDao.getJobPosition())
                .salary(offerDao.getSalary())
                .offerUrl(offerDao.getOfferUrl())
                .build();
    }
}
