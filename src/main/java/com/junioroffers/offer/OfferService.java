package com.junioroffers.offer;

import com.junioroffers.offer.domain.dto.OfferDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;

    public List<OfferDto> getOffers() {
        return offerRepository.getAllOffers();
    }

    public OfferDto getOfferById(Long id) {
        return offerRepository.getOfferById(id).orElse(null);
    }

    public OfferDto createOrUpdateOffer(OfferDto offerDto) {
        return offerRepository.createOrUpdateOffer(offerDto);
    }

    public int deleteOfferById(Long id) {
        return offerRepository.deleteOfferById(id);
    }
}
