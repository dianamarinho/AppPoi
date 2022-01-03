package com.poi.pointOfInterest.services;

import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.repository.PoiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PoiServiceTest {

    @MockBean
    PoiRepository poiRepository;

    @InjectMocks
    PoiService poiService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllThePoiInDatabase() {

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");PointOfInterest pointOfInterest1 = new PointOfInterest();
        pointOfInterest.setId(2);
        pointOfInterest.setName("Sofia");
        pointOfInterest.setCity("Porto");

        Mockito
                .when(poiRepository.findAll())
                .thenReturn(Flux.just(pointOfInterest, pointOfInterest1));

        Flux<PointOfInterest> pointOfInterestFlux = poiService.getAllPoi();

        StepVerifier
                .create(pointOfInterestFlux)
                .expectNextCount(2)
                .verifyComplete();


    }

    @Test
    void shouldGetOnlyOnePoiById() {

        Integer id = 1;
        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        Mockito
                .when(poiRepository.findById(1))
                .thenReturn(Mono.just(pointOfInterest));

        Mono<PointOfInterest> pointOfInterestMono = poiService.getOnlyOnePoi(1);

        StepVerifier
                .create(pointOfInterestMono)
                .consumeNextWith(pointOfInterest1 -> assertEquals(pointOfInterest.getId(), pointOfInterest1.getId()))
                .verifyComplete();
    }

    @Test
    void shouldAddOnePoiToDatabase() {
        Integer id = 1;
        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        Mockito
                .when(poiRepository.save(pointOfInterest))
                .thenReturn(Mono.just(pointOfInterest));

        Mono<PointOfInterest> pointOfInterestMono = poiService.addNewPoi(pointOfInterest);

        StepVerifier
                .create(pointOfInterestMono)
                .consumeNextWith(pointOfInterest1 -> assertEquals(pointOfInterest.getId(), pointOfInterest1.getId()))
                .verifyComplete();

    }

    @Test
    void shouldDeleteOnePoiFromDatabase() {

        Integer id = 1;
        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        Mockito
                .when(poiRepository.deleteById(1))
                .thenReturn(Mono.empty());

        Mono<Void> pointOfInterestMono = poiService.deleteOnlyOnePoi(id);

        StepVerifier
                .create(pointOfInterestMono)
                .verifyComplete();
    }

    @Test
    void shouldDeleteAllPoiFromDatabase() {
        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        Mockito
                .when(poiRepository.deleteAll())
                .thenReturn(Mono.empty());

        Mono<Void> pointOfInterestMono = poiService.deleteAllPoi();

        StepVerifier
                .create(pointOfInterestMono)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void shouldUpdateOnePoiByIdAndUpdate() {

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        Mockito
                .when(poiRepository.findById(pointOfInterest.getId()))
                .thenReturn(Mono.just(pointOfInterest));
        Mockito
                .when(poiRepository.save(pointOfInterest))
                .thenReturn(Mono.just(pointOfInterest));

        Mono<PointOfInterest> pointOfInterestMono = poiService.updatePoi(pointOfInterest.getId(), pointOfInterest);

        StepVerifier
                .create(pointOfInterestMono)
                .consumeNextWith(pointOfInterest1 -> assertEquals(pointOfInterest1.hashCode(), pointOfInterest.hashCode()))
                .verifyComplete();
    }
}