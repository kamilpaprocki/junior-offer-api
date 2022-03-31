package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.client.dto.JobOfferDto;
import java.util.List;

public interface RemoteOfferClient {

    List<JobOfferDto> getOffers();
}
