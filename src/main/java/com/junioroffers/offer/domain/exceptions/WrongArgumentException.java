package com.junioroffers.offer.domain.exceptions;

public class WrongArgumentException extends RuntimeException {

    public WrongArgumentException(String message) {
        super(message);
    }
}
