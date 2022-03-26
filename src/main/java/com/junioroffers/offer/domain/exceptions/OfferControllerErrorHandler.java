package com.junioroffers.offer.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.Date;

@ControllerAdvice
public class OfferControllerErrorHandler {

    @ExceptionHandler(value = OfferNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    protected OfferErrorResponse handleOfferNotFoundException(RuntimeException e) {
        return new OfferErrorResponse(e.getMessage(), new Date().toString(), HttpStatus.NOT_FOUND);
    }
}
