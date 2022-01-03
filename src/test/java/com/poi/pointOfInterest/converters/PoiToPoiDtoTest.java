package com.poi.pointOfInterest.converters;

import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.dto.PointOfInterestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PoiToPoiDtoTest {

    @InjectMocks
    PoiToPoiDto poiToPoiDto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void convertPoiIntoPoiDto() {
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

        Mono<PointOfInterestDto> pointOfInterestDtoMono = Mono.just(poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest));

        StepVerifier
                .create(pointOfInterestDtoMono)
                .consumeNextWith(pointOfInterestDto1 -> assertEquals(pointOfInterest.getId(), pointOfInterestDto1.getId()))
                .verifyComplete();
    }
}