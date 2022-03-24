package com.junioroffers.infrastructure.offer.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class RestClient extends RestTemplate {

    private String url;

    public <T> ResponseEntity<List<T>> callGetMethod(ParameterizedTypeReference<List<T>> responseType) {
        return super.exchange(url, HttpMethod.GET, null, responseType);
    }
}
