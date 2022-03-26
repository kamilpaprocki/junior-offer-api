package com.junioroffers.offer;

import com.junioroffers.offer.domain.dto.OfferDto;
import com.junioroffers.offer.domain.exceptions.OfferNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OfferController {

    private OfferService offerService;

    @GetMapping("/offers")
    public ResponseEntity<List<OfferDto>> getOffers() {
        List<OfferDto> offers = offerService.getOffers();
        if (offers.isEmpty()){
            throw new OfferNotFoundException("There are no offers");
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<OfferDto> getOffer(@PathVariable Long id){
        OfferDto offer = offerService.getOffer(id);
        if (offer == null){
            throw new OfferNotFoundException("There is no offer with id: " + id);
        }
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }
}
