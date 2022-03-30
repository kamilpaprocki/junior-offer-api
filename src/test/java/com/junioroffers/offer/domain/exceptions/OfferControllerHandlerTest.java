package com.junioroffers.offer.domain.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import java.util.Date;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OfferControllerHandlerTest {

    OfferControllerErrorHandler errorHandler = new OfferControllerErrorHandler();

    @Test
    public void should_return_offer_response_with_offerNotFoundException() {
        //GIVEN
        OfferErrorResponse expectedOfferResponse = returnOfferErrorResponseWithOfferNotFoundException();
        //WHEN
        OfferErrorResponse receivedOfferResponse = errorHandler.handleOfferNotFoundException(returnOfferNotFoundException());
        //THEN
        assertThat(expectedOfferResponse).isEqualTo(receivedOfferResponse);
    }

    @Test
    public void should_return_offer_response_with_wrongArgumentException() {
        //GIVEN
        OfferErrorResponse expectedOfferResponse = returnOfferErrorResponseWithWrongArgumentException();
        //WHEN
        OfferErrorResponse receivedOfferResponse = errorHandler.handleWrongArgumentException(returnWrongArgumentException());
        //THEN
        assertThat(expectedOfferResponse).isEqualTo(receivedOfferResponse);
    }

    private OfferNotFoundException returnOfferNotFoundException() {
        return new OfferNotFoundException("");
    }

    private OfferErrorResponse returnOfferErrorResponseWithOfferNotFoundException() {
        return new OfferErrorResponse("", new Date().toString(), HttpStatus.NOT_FOUND);
    }

    private WrongArgumentException returnWrongArgumentException() {
        return new WrongArgumentException("");
    }

    private OfferErrorResponse returnOfferErrorResponseWithWrongArgumentException() {
        return new OfferErrorResponse("", new Date().toString(), HttpStatus.BAD_REQUEST);
    }
}
