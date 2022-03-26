package com.junioroffers.infrastructure.offer.client.exceptions;

public class OfferNotFoundException extends RuntimeException {
    public OfferNotFoundException(String message) {
        super(message);
    }
}
