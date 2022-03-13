package com.junioroffers.infrastructure.offer.client;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@AllArgsConstructor
public class RestClient extends RestTemplate{

    public <T> ResponseEntity<List<T>> callGetMethod(String url, ParameterizedTypeReference<List<T>> responseType){
        return super.exchange(url, HttpMethod.GET, null, responseType);

    }




}
