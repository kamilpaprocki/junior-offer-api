package com.junioroffers.offer.config;

import com.junioroffers.offer.OfferController;
import com.junioroffers.offer.OfferRepository;
import com.junioroffers.offer.OfferService;
import com.junioroffers.offer.domain.OfferMapper;
import com.junioroffers.offer.domain.dto.OfferDto;
import com.junioroffers.offer.domain.dto.SampleOfferDtoImpl;
import com.junioroffers.offer.domain.exceptions.OfferControllerErrorHandler;
import com.junioroffers.offer.domain.exceptions.WrongArgumentException;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;


public class MockMvcConfig implements SampleOfferDtoImpl {

    @Bean
    OfferService offerServiceImpl() {
        OfferRepository offerRepository = mock(OfferRepository.class);
        return new OfferService(offerRepository, offerMapperImpl()) {

            @Override
            public List<OfferDto> getOffers() {
                return Arrays.asList(firstOfferDtoWithId(), secondOfferDtoWithId());
            }

            @Override
            public OfferDto getOfferById(String id) {
                try {
                    Long.parseLong(id);
                    if ("1".equals(id)) {
                        return firstOfferDtoWithId();
                    }
                    if ("2".equals(id)) {
                        return secondOfferDtoWithId();
                    }
                    return null;
                } catch (NumberFormatException e) {
                    throw new WrongArgumentException("Offer id isn't a number.");
                }
            }

            @Override
            public OfferDto createOrUpdateOffer(OfferDto offerDto) {
                if (offerDto.getId() != null) {
                    return firstOfferDtoWithId();
                }
                return firstOfferDtoWithoutId();
            }

            @Override
            public int deleteOfferById(String id) {
                try {
                    Long.parseLong(id);
                    if ("1".equals(id)) {
                        return 1;
                    }
                    return 0;
                } catch (NumberFormatException e) {
                    throw new WrongArgumentException("Offer id isn't a number.");
                }
            }
        };
    }

    OfferMapper offerMapperImpl() {
        return new OfferMapper();
    }

    @Bean
    OfferController offerControllerImpl(OfferService offerService) {
        return new OfferController(offerService);
    }

    @Bean
    OfferControllerErrorHandler offerControllerErrorHandlerImpl() {
        return new OfferControllerErrorHandler();
    }
}
