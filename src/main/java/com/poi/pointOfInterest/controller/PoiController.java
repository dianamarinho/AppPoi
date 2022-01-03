package com.poi.pointOfInterest.controller;

import com.poi.pointOfInterest.converters.PoiDtoToPoi;
import com.poi.pointOfInterest.converters.PoiToPoiDto;
import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.dto.PointOfInterestDto;
import com.poi.pointOfInterest.repository.PoiRepository;
import com.poi.pointOfInterest.services.PoiService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller responsible for {@link PointOfInterest} related CRUD operations
 */
@RestController
@RequestMapping("/api")
public class PoiController {

    private PoiService poiService;
    private PoiToPoiDto poiToPoiDto;
    private PoiDtoToPoi poiDtoToPoi;

    /**
     * Sets the params
     * @param poiService the Service to set
     * @param poiToPoiDto the converter to set
     * @param poiDtoToPoi the converter to set
     */
    public PoiController(PoiService poiService, PoiToPoiDto poiToPoiDto, PoiDtoToPoi poiDtoToPoi){
        this.poiService = poiService;
        this.poiToPoiDto = poiToPoiDto;
        this.poiDtoToPoi = poiDtoToPoi;
    }

    /**
     * Retrieves one flux that represents a list os Points of Interest
     *
     * @return the flux with the POIs
     */
    @GetMapping
    public Flux<PointOfInterestDto> seeAllPoi(){
           return poiService.getAllPoi().map(pointOfInterest -> poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest));
    }

    /**
     * Retrieves a Mono with the Point Of Interest that I want to consult
     *
     * @param id the id of the POI
     *
     * @return the mono with the POI Dto
     */
    @GetMapping("/consult/{id}")
    public Mono<PointOfInterestDto> seeOnePoi(@PathVariable Integer id){
        return poiService.getOnlyOnePoi(id).map(pointOfInterest -> poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest));
    }

    /**
     * Add a Point of Interest
     *
     * @param pointOfInterest the Point Of Interest to add
     *
     * @return the POI added
     */
    @PostMapping("/adding")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PointOfInterestDto> addOnePoi(@RequestBody PointOfInterest pointOfInterest){
        return poiService.addNewPoi(pointOfInterest).map(pointOfInterest1 -> poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest));
    }

    /**
     * Delete one Point of Interest
     *
     * @param id the POI that I want to delete
     *
     * @return an empty mono
     */
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deletePoi(@PathVariable Integer id){
        return poiService.deleteOnlyOnePoi(id);
    }

    /**
     * Delete all the Points of Interest avaible in the database
     *
     * @return an empty mono
     */
    @DeleteMapping("/delete")
    public Mono<Void> deleteAllPoi(){
        return poiService.deleteAllPoi();
    }

    /**
     * Update a Point of Interest
     *
     * @param id the id of the POI to update
     * @param pointOfInterest the updates to do in the POI
     *
     * @return the updated POI
     */
    @PutMapping("/updating/{id}")
    public Mono<PointOfInterestDto> updatePoi(@PathVariable Integer id, @RequestBody PointOfInterest pointOfInterest){
        return poiService.updatePoi(id, pointOfInterest).map(pointOfInterest1 -> poiToPoiDto.convertPoiIntoPoiDto(pointOfInterest));
    }

}
