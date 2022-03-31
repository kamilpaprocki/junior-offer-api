package com.junioroffers.infrastructure.offer.client.exceptions;

public class JobOfferNotFoundException extends RuntimeException {
    public JobOfferNotFoundException(String message) {
        super(message);
    }
}
