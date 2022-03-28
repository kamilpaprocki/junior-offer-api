package com.junioroffers.offer;

import com.junioroffers.offer.domain.dto.OfferDto;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class OfferRepository {

    private Map<Long, OfferDto> offers;

    public OfferRepository() {
        offers = new HashMap<>();
        implOffers();
    }

    public List<OfferDto> getAllOffers() {
        if (offers.isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(offers.values());
    }

    private void implOffers() {
        offers.put(1L, new OfferDto(1L, "S2Innovation Sp. z o. o.",
                "Junior Remote Java Developer",
                "4k - 8k PLN",
                "https://nofluffjobs.com/pl/job/junior-remote-java-developer-s2innovation-krakow-stddogtj"));
        offers.put(2L, new OfferDto(2L, "HARMAN Connected Services",
                "Junior Java SE Developer for Automotive",
                "7k - 10k PLN",
                "https://nofluffjobs.com/pl/job/junior-java-se-developer-for-automotive-harman-connected-services-lodz-yafxatha"));
    }

    public Optional<OfferDto> getOfferById(Long id) {
        if (!offers.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(offers.get(id));
    }

    public OfferDto createOrUpdateOffer(OfferDto offerDto) {
        if (offerDto.getId() == null) {
            long lastId = offers.keySet().size();
            lastId++;
            offerDto.setId(lastId);
            offers.put(lastId, offerDto);
        } else {
            offers.put(offerDto.getId(), offerDto);
        }
        return offerDto;
    }

    public int deleteOfferById(Long id) {
        if (offers.containsKey(id)) {
            offers.remove(id);
            return 1;
        }
        return 0;
    }
}
