package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.client.dto.OfferDTO;
import com.junioroffers.infrastructure.offer.client.exceptions.HttpClientException;
import com.junioroffers.infrastructure.offer.client.exceptions.OfferNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import java.util.List;

@Component
@AllArgsConstructor
public class OfferClient implements RemoteOfferClient {

    private final RestClient restClient;

    public List<OfferDTO> getOffers() {
        List<OfferDTO> offerDTOList;
        try {
            ResponseEntity<List<OfferDTO>> responseEntity = restClient.callGetMethod(new ParameterizedTypeReference<List<OfferDTO>>() {
            });
            offerDTOList = responseEntity.getBody();
            if (offerDTOList != null && offerDTOList.isEmpty()) {
                throw new OfferNotFoundException("There are no offers");
            }
        } catch (RestClientException e) {
            throw new HttpClientException(e.getMessage());
        }
        return offerDTOList;
    }
}
