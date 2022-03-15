package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.client.dto.OfferDTO;
import com.junioroffers.infrastructure.offer.client.exceptions.OfferNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.when;

public class OfferClientTests {

    @Test
    public void should_return_offer_DTOs_list(){
        //GIVEN
        RestClient restClient = Mockito.mock(RestClient.class);
        when(restClient.callGetMethod(ArgumentMatchers.anyString(), ArgumentMatchers.<ParameterizedTypeReference<List<OfferDTO>>>any()))
                .thenReturn(new ResponseEntity<>(Collections.singletonList(new OfferDTO()), HttpStatus.ACCEPTED));
        OfferClient offerClient = new OfferClient(restClient);
        //WHEN
        List<OfferDTO> offerDTOS = offerClient.getOffers();
        //THEN
        assertThat(offerDTOS.size()).isEqualTo(1);
    }

    @Test
    public void should_throw_OfferNotFoundException_when_return_list_is_empty(){
        //GIVEN
        RestClient restClient = Mockito.mock(RestClient.class);
        when(restClient.callGetMethod(ArgumentMatchers.anyString(), ArgumentMatchers.<ParameterizedTypeReference<List<OfferDTO>>>any()))
                .thenReturn(null);
        OfferClient offerClient = new OfferClient(restClient);
        //WHEN THEN
        assertThrows(OfferNotFoundException.class, offerClient::getOffers);
    }

}
