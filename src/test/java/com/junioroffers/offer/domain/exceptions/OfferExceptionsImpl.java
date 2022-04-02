package com.junioroffers.offer.domain.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public interface OfferExceptionsImpl {

    default OfferNotFoundException returnOfferNotFoundException() {
        return new OfferNotFoundException("");
    }

    default OfferErrorResponse returnOfferErrorResponseWithOfferNotFoundException() {
        return new OfferErrorResponse("", new Date().toString(), HttpStatus.NOT_FOUND);
    }

    default WrongArgumentException returnWrongArgumentException() {
        return new WrongArgumentException("");
    }

    default OfferErrorResponse returnOfferErrorResponseWithWrongArgumentException() {
        return new OfferErrorResponse("", new Date().toString(), HttpStatus.BAD_REQUEST);
    }
}
