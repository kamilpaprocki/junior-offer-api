package com.junioroffers.offer;

import com.junioroffers.offer.domain.OfferMapper;
import com.junioroffers.offer.domain.dto.OfferDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private OfferMapper offerMapper;

    public List<OfferDto> getOffers() {
        return offerRepository.getAllOffers().stream().map(offerMapper::mapToOfferDto).collect(Collectors.toList());
    }

    public OfferDto getOfferById(Long id) {
        return offerMapper.mapToOfferDto(offerRepository.getOfferById(id).orElse(null));
    }

    public OfferDto createOrUpdateOffer(OfferDto offerDto) {
        offerRepository.createOrUpdateOffer(offerMapper.mapToOfferDao(offerDto));
        return offerDto;
    }

    public int deleteOfferById(Long id) {
        return offerRepository.deleteOfferById(id);
    }
}
