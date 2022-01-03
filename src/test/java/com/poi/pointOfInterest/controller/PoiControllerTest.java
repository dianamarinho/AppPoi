package com.poi.pointOfInterest.controller;

import com.poi.pointOfInterest.converters.PoiDtoToPoi;
import com.poi.pointOfInterest.converters.PoiToPoiDto;
import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.dto.PointOfInterestDto;
import com.poi.pointOfInterest.services.PoiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

@SpringBootTest
class PoiControllerTest {

    @MockBean
    PoiService poiService;

    @Autowired
    PoiDtoToPoi poiDtoToPoi;

    @Autowired
    PoiToPoiDto poiToPoiDto;

    private WebTestClient webTestClient;


    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);

        this.webTestClient =
                WebTestClient.bindToController(new PoiController(poiService, poiToPoiDto, poiDtoToPoi))
                        .configureClient()
                        .baseUrl("/api")
                        .build();
    }
    @Test
    void shouldShowAllPoi() {
        Integer id = 1;
        String name = "Diana";
        String city = "Porto";

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(id);
        pointOfInterest.setName(name);
        pointOfInterest.setCity(city);

        PointOfInterestDto pointOfInterestDto = poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest);

        Mockito
                .when(poiService.getAllPoi())
                .thenReturn(Flux.just(pointOfInterest));

        List<PointOfInterestDto> pointOfInterestDtoList = List.of(pointOfInterestDto);


        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(PointOfInterestDto.class)
                .isEqualTo(pointOfInterestDtoList);

    }

    @Test
    void shouldShowOnlyOnePoi() {

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        PointOfInterestDto pointOfInterestDto = poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest);

        Mockito
                .when(poiService.getOnlyOnePoi(1))
                .thenReturn(Mono.just(pointOfInterest));

        Mono<PointOfInterestDto> pointOfInterestDtoMono = Mono.just(pointOfInterestDto);

        webTestClient.get().uri("/consult/{id}", pointOfInterestDto.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(PointOfInterestDto.class)
                .isEqualTo(pointOfInterestDto);
    }

    @Test
    void shouldAddOnePoi() {

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        PointOfInterestDto pointOfInterestDto = poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest);

        Mockito
                .when(poiService.addNewPoi(pointOfInterest))
                .thenReturn(Mono.just(pointOfInterest));


        webTestClient
                .post()
                .uri("/adding")
                .bodyValue(pointOfInterest)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(PointOfInterestDto.class)
                .isEqualTo(pointOfInterestDto);
    }

    @Test
    void shouldDeletePoi() {

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        Mockito
                .when(poiService.deleteOnlyOnePoi(pointOfInterest.getId()))
                .thenReturn(Mono.empty());

        webTestClient
                .delete()
                .uri("/delete/{id}", pointOfInterest.getId())
                .exchange();

    }

    @Test
    void shouldDeleteAllPoi() {

        Mockito
                .when(poiService.deleteAllPoi())
                .thenReturn(Mono.empty());

        webTestClient
                .delete()
                .uri("/delete")
                .exchange();
    }

    @Test
    void shouldUpdatePoi() {

        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(1);
        pointOfInterest.setName("Diana");
        pointOfInterest.setCity("Porto");

        PointOfInterestDto pointOfInterestDto = poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest);

        Mockito
                .when(poiService.updatePoi(pointOfInterest.getId(), pointOfInterest))
                .thenReturn(Mono.just(pointOfInterest));

        webTestClient
                .put()
                .uri("/updating/{id}", pointOfInterestDto.getId())
                .bodyValue(pointOfInterest)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(PointOfInterestDto.class)
                .isEqualTo(pointOfInterestDto);

    }
}