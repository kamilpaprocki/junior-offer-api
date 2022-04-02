package com.junioroffers.offer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junioroffers.offer.config.MockMvcConfig;
import com.junioroffers.offer.domain.dto.OfferDto;
import com.junioroffers.offer.domain.dto.SampleOfferDtoImpl;
import com.junioroffers.offer.domain.exceptions.OfferErrorResponse;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = MockMvcConfig.class)
public class OfferControllerTest implements SampleOfferDtoImpl {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void should_return_list_with_offer() throws Exception {
        //GIVEN
        List<OfferDto> offers = Lists.newArrayList(firstOfferDtoWithId(), secondOfferDtoWithId());
        String exceptedResponse = objectMapper.writeValueAsString(offers);
        //WHEN
        MvcResult mvcResult = mockMvc.perform(get("/offers")).andExpect(status().isOk()).andReturn();
        String receivedResponse = mvcResult.getResponse().getContentAsString();
        //THEN
        assertThat(receivedResponse).isEqualTo(exceptedResponse);
    }

    @Test
    public void should_return_status_ok_when_get_for_offer_with_given_id() throws Exception {
        //GIVEN
        OfferDto secondOffer = secondOfferDtoWithId();
        String expectedResponse = objectMapper.writeValueAsString(secondOffer);
        int offerId = 2;
        //WHEN
        MvcResult mvcResult = mockMvc.perform(get("/offers/" + offerId)).andExpect(status().isOk()).andReturn();
        String receivedResponse = mvcResult.getResponse().getContentAsString();
        //THEN
        assertThat(receivedResponse).isEqualTo(expectedResponse);
    }

    @Test
    public void should_return_status_not_found_when_there_is_not_offer_with_given_id_while_get_method() throws Exception {
        //GIVEN
        int offerId = 500;
        OfferErrorResponse offerErrorResponse = new OfferErrorResponse("There is no offer with id: " + offerId, new Date().toString(), HttpStatus.NOT_FOUND);
        String errorResponse = objectMapper.writeValueAsString(offerErrorResponse);
        //WHEN
        MvcResult mvcResult = mockMvc.perform(get("/offers/" + offerId)).andExpect(status().isNotFound()).andReturn();
        String receivedResponse = mvcResult.getResponse().getContentAsString();
        //THEN
        assertThat(receivedResponse).isEqualTo(errorResponse);
    }

    @Test
    public void should_return_status_bad_request_when_given_id_is_not_a_number() throws Exception {
        //GIVEN
        String offerId = "s";
        OfferErrorResponse offerErrorResponse = new OfferErrorResponse("Offer id isn't a number.", new Date().toString(), HttpStatus.BAD_REQUEST);
        String badRequestResponse = objectMapper.writeValueAsString(offerErrorResponse);
        //WHEN
        MvcResult mvcResult = mockMvc.perform(get("/offers/" + offerId)).andExpect(status().isBadRequest()).andReturn();
        String receivedResponse = mvcResult.getResponse().getContentAsString();
        //THEN
        assertThat(receivedResponse).isEqualTo(badRequestResponse);
    }

    @Test
    public void should_return_status_ok_when_offer_is_updated() throws Exception {
        //GIVEN
        String updatedOffer = objectMapper.writeValueAsString(firstOfferDtoWithId());
        //WHEN
        MvcResult mvcResult = mockMvc.perform(post("/offers").contentType(MediaType.APPLICATION_JSON).content(updatedOffer))
                .andExpect(status().isOk()).andReturn();
        String receivedResponse = mvcResult.getResponse().getContentAsString();
        //THEN
        assertThat(receivedResponse).isEqualTo(updatedOffer);
    }

    @Test
    public void should_return_status_created_when_new_offer_is_created() throws Exception {
        //GIVEN
        String createdOffer = objectMapper.writeValueAsString(firstOfferDtoWithoutId());
        //WHEN
        MvcResult mvcResult = mockMvc.perform(post("/offers")
                        .contentType(MediaType.APPLICATION_JSON).content(createdOffer))
                .andExpect(status().isCreated()).andReturn();
        String receivedResponse = mvcResult.getResponse().getContentAsString();
        //THEN
        assertThat(receivedResponse).isEqualTo(createdOffer);
    }

    @Test
    public void should_return_status_ok_when_offer_is_successful_deleted() throws Exception {
        //GIVEN
        int offerId = 1;
        //WHEN
        MvcResult mvcResult = mockMvc.perform(delete("/offers/" + offerId)).andExpect(status().isOk()).andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        //THEN
        assertThat(responseStatus).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void should_return_status_not_modified_when_there_is_no_offer_with_given_id_while_delete_method() throws Exception {
        //GIVEN
        int offerId = 500;
        //WHEN
        MvcResult mvcResult = mockMvc.perform(delete("/offers/" + offerId)).andExpect(status().isNotModified()).andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        //THEN
        assertThat(responseStatus).isEqualTo(HttpStatus.NOT_MODIFIED.value());
    }
}
