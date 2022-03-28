package com.junioroffers.offer;

import com.junioroffers.offer.domain.dao.OfferDao;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class OfferRepository {

    private Map<Long, OfferDao> offers;

    public OfferRepository() {
        offers = new HashMap<>();
        implOffers();
    }

    public List<OfferDao> getAllOffers() {
        if (offers.isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(offers.values());
    }

    private void implOffers() {
        offers.put(1L, new OfferDao(1L, "S2Innovation Sp. z o. o.",
                "Junior Remote Java Developer",
                "4k - 8k PLN",
                "https://nofluffjobs.com/pl/job/junior-remote-java-developer-s2innovation-krakow-stddogtj"));
        offers.put(2L, new OfferDao(2L, "HARMAN Connected Services",
                "Junior Java SE Developer for Automotive",
                "7k - 10k PLN",
                "https://nofluffjobs.com/pl/job/junior-java-se-developer-for-automotive-harman-connected-services-lodz-yafxatha"));
    }

    public Optional<OfferDao> getOfferById(Long id) {
        if (!offers.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(offers.get(id));
    }

    public OfferDao createOrUpdateOffer(OfferDao offerDao) {
        if (offerDao.getId() == null) {
            long lastId = offers.keySet().size();
            lastId++;
            offerDao.setId(lastId);
            offers.put(lastId, offerDao);
        } else {
            offers.put(offerDao.getId(), offerDao);
        }
        return offerDao;
    }

    public int deleteOfferById(Long id) {
        if (offers.containsKey(id)) {
            offers.remove(id);
            return 1;
        }
        return 0;
    }
}
