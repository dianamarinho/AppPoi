package com.poi.pointOfInterest.converters;

import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.dto.PointOfInterestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class PoiDtoToPoiTest {

    @InjectMocks
    PoiDtoToPoi poiDtoToPoi;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convertPoiDtoIntoPoi() {
        Integer id = 1;
        String name = "Diana";
        String city = "Porto";

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(id);
        pointOfInterest.setName(name);
        pointOfInterest.setCity(city);

        PointOfInterestDto pointOfInterestDto = new PointOfInterestDto();
        pointOfInterestDto.setId(id);
        pointOfInterestDto.setName(name);
        pointOfInterestDto.setCity(city);

        Mono<PointOfInterest> pointOfInterestMono = Mono.just(poiDtoToPoi.convertPoiDtoIntoPoi(pointOfInterestDto));

        StepVerifier
                .create(pointOfInterestMono)
                .consumeNextWith(pointOfInterest1 -> assertEquals(pointOfInterest1.getId(), pointOfInterestDto.getId()))
                .verifyComplete();
    }
}