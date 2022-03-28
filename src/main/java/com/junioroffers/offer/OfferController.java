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
        if (offers.isEmpty()) {
            throw new OfferNotFoundException("There are no offers");
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<OfferDto> getOfferById(@PathVariable Long id) {
        OfferDto offer = offerService.getOfferById(id);
        if (offer == null) {
            throw new OfferNotFoundException("There is no offer with id: " + id);
        }
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping("/offers")
    public ResponseEntity<OfferDto> createOrUpdateOffer(@RequestBody OfferDto offerDto) {
        if (offerDto.getId() != null) {
            return new ResponseEntity<>(offerService.createOrUpdateOffer(offerDto), HttpStatus.OK);
        }
        return new ResponseEntity<>(offerService.createOrUpdateOffer(offerDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/offers/{id}")
    public ResponseEntity<OfferDto> deleteOffer(@PathVariable Long id) {
        if (offerService.deleteOfferById(id) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
