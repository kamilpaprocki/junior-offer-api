package com.junioroffers.offer.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class OfferErrorResponse {

    private String message;
    private String timestamp;
    private HttpStatus httpStatus;
}
