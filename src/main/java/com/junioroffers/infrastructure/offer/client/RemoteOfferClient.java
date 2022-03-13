package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.client.dto.OfferDTO;
import java.util.List;

public interface RemoteOfferClient {

    List<OfferDTO> getOffers();
}
