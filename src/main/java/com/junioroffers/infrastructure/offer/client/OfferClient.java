package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.client.dto.OfferDTO;
import com.junioroffers.infrastructure.offer.client.exceptions.OfferNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OfferClient implements RemoteOfferClient{

    private final static String OFFER_URL = "http://programming-masterpiece.com:5057/offers";
    private final RestClient restClient;

    public List<OfferDTO> getOffers() {
        List<OfferDTO> offerDTOList;
        ResponseEntity<List<OfferDTO>> responseEntity = restClient.callGetMethod(OFFER_URL, new ParameterizedTypeReference<List<OfferDTO>>() {
        });

        if (responseEntity == null) {
            throw new OfferNotFoundException("There are no offers");
        }
        offerDTOList = responseEntity.getBody();
        return offerDTOList;

    }


}
