package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.client.dto.OfferDto;
import java.util.List;

public interface RemoteOfferClient {

    List<OfferDto> getOffers();
}
