package com.junioroffers.offer.domain;

import com.junioroffers.offer.domain.dao.OfferDao;
import com.junioroffers.offer.domain.dto.OfferDto;

public class OfferMapper {

    public OfferDto mapToOfferDto(OfferDao offerDao) {
        if (offerDao == null) {
            return null;
        }
        return OfferDto.builder()
                .id(offerDao.getId())
                .companyName(offerDao.getCompanyName())
                .jobPosition(offerDao.getJobPosition())
                .salary(offerDao.getSalary())
                .offerUrl(offerDao.getOfferUrl())
                .build();
    }

    public OfferDao mapToOfferDao(OfferDto offerDto) {
        if (offerDto == null) {
            return null;
        }
        return OfferDao.builder()
                .id(offerDto.getId())
                .companyName(offerDto.getCompanyName())
                .jobPosition(offerDto.getJobPosition())
                .salary(offerDto.getSalary())
                .offerUrl(offerDto.getOfferUrl())
                .build();
    }
}
