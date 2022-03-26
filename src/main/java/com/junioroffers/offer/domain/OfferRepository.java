package com.junioroffers.offer.domain;

import com.junioroffers.offer.domain.dto.OfferDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OfferRepository {

    private Map<Long, OfferDto> offers;

    public OfferRepository(){
        offers = new HashMap<>();
        offers.put(1L, new OfferDto("S2Innovation Sp. z o. o.",
                "Junior Remote Java Developer",
                "4k - 8k PLN",
                "https://nofluffjobs.com/pl/job/junior-remote-java-developer-s2innovation-krakow-stddogtj" ));
        offers.put(2L, new OfferDto("HARMAN Connected Services",
                "Junior Java SE Developer for Automotive",
                "7k - 10k PLN",
                "https://nofluffjobs.com/pl/job/junior-java-se-developer-for-automotive-harman-connected-services-lodz-yafxatha"));
    }


}
