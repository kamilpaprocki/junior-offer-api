package com.junioroffers.offer;

import com.junioroffers.offer.domain.dto.OfferDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
public class OfferController {

    private OfferService offerService;

    @GetMapping("/offers")
    public ResponseEntity<List<OfferDto>> getOffers() {
        return new ResponseEntity<>(offerService.getOffers(), HttpStatus.OK);
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<OfferDto> getOffer(@PathVariable Long id){
        return new ResponseEntity<>(offerService.getOffer(id), HttpStatus.OK);
    }
}
