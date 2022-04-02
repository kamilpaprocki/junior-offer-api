package com.junioroffers.offer;

import com.junioroffers.offer.config.OfferTestConfig;
import com.junioroffers.offer.domain.OfferMapper;
import com.junioroffers.offer.domain.dto.OfferDto;
import com.junioroffers.offer.domain.dto.SampleOfferDaoImpl;
import com.junioroffers.offer.domain.exceptions.WrongArgumentException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class OfferServiceTest implements SampleOfferDaoImpl {

    OfferRepository offerRepository = Mockito.mock(OfferRepository.class);
    OfferMapper offerMapper = new OfferTestConfig().offerMapperImpl();
    OfferService offerService = new OfferService(offerRepository, offerMapper);

    @Test
    public void should_return_offer_list() {
        //GIVEN
        when(offerRepository.getAllOffers()).thenReturn(Collections.singletonList(returnOneOfferDao()));
        //WHEN
        List<OfferDto> offers = offerService.getOffers();
        //THEN
        assertThat(offers.size()).isEqualTo(1);
    }

    @Test
    public void should_return_empty_list_when_there_is_no_offers() {
        //GIVEN
        when(offerRepository.getAllOffers()).thenReturn(Collections.emptyList());
        //WHEN
        List<OfferDto> offers = offerService.getOffers();
        //THEN
        assertThat(offers.size()).isEqualTo(0);
    }

    @Test
    public void should_return_offer_with_given_offer_id() {
        //GIVEN
        when(offerRepository.getOfferById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(returnOneOfferDao()));
        //WHEN
        OfferDto offer = offerService.getOfferById(String.valueOf(ArgumentMatchers.anyLong()));
        //THEN
        assertThat(offer).isInstanceOf(OfferDto.class).isNotNull();
    }

    @Test
    public void should_return_null_when_there_is_no_offer_with_given_id() {
        //GIVEN
        when(offerRepository.getOfferById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());
        //WHEN
        OfferDto offer = offerService.getOfferById(String.valueOf(ArgumentMatchers.anyLong()));
        //THEN
        assertThat(offer).isNull();
    }

    @Test
    public void should_throw_WrongArgumentException_when_offer_id_is_not_a_number_in_get_offer_by_id_method() {
        //GIVEN //WHEN //THEN
        assertThrows(WrongArgumentException.class, () -> offerService.getOfferById(""));
    }

    @Test
    public void should_return_1_when_offer_will_be_delete_with_given_id() {
        //GIVEN
        when(offerRepository.deleteOfferById(ArgumentMatchers.anyLong())).thenReturn(1);
        //WHEN
        int result = offerService.deleteOfferById(String.valueOf(ArgumentMatchers.anyLong()));
        //THEN
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void return_offer_with_all_fields_not_null_when_offer_is_updating() {
        //GIVEN
        when(offerRepository.createOrUpdateOffer(returnOneOfferDao())).thenReturn(returnOneOfferDao());
        //WHEN
        OfferDto offer = offerService.createOrUpdateOffer(offerMapper.mapToOfferDto(returnOneOfferDao()));
        //THEN
        assertThat(offer).isNotNull().hasNoNullFieldsOrProperties();
    }

    @Test
    public void return_offer_without_id_when_offer_is_creating() {
        //GIVEN
        when(offerRepository.createOrUpdateOffer(returnOneOfferDaoWithoutId())).thenReturn(returnOneOfferDaoWithoutId());
        //WHEN
        OfferDto offer = offerService.createOrUpdateOffer(offerMapper.mapToOfferDto(returnOneOfferDaoWithoutId()));
        //THEN
        assertThat(offer).isNotNull().hasFieldOrPropertyWithValue("id", null);
    }

    @Test
    public void should_return_0_where_there_is_no_offer_with_given_id() {
        //GIVEN
        when(offerRepository.deleteOfferById(ArgumentMatchers.anyLong())).thenReturn(0);
        //WHEN
        int result = offerService.deleteOfferById(String.valueOf(ArgumentMatchers.anyLong()));
        //THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_throw_WrongArgumentException_when_offer_id_is_not_a_number_in_delete_offer_by_id_method() {
        //GIVEN //WHEN //THEN
        assertThrows(WrongArgumentException.class, () -> offerService.deleteOfferById(""));
    }
}
