package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.client.dto.OfferDto;
import com.junioroffers.infrastructure.offer.client.exceptions.HttpClientException;
import com.junioroffers.infrastructure.offer.client.exceptions.OfferNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class OfferClient implements RemoteOfferClient {

    private final RestClient restClient;

    public List<OfferDto> getOffers() {
        List<OfferDto> offers;
        try {
            ResponseEntity<List<OfferDto>> responseEntity = restClient.callGetMethod(new ParameterizedTypeReference<List<OfferDto>>() {
            });
            offers = responseEntity.getBody();
            if (offers != null && offers.isEmpty()) {
                log.error("Return empty offer list.");
                throw new OfferNotFoundException("There are no offers");
            }
        } catch (RestClientException e) {
            log.error("Throw RestClient exception with message {}.", e.getMessage());
            throw new HttpClientException(e.getMessage());
        }
        log.info("Return list with {} offers.", offers.size());
        return offers;
    }
}
