package com.poi.pointOfInterest.services;

import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.dto.PointOfInterestDto;
import com.poi.pointOfInterest.repository.PoiRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PoiService {

    private PoiRepository poiRepository;

    /**
     * Sets the properties
     *
     * @param poiRepository the Point of Interest repository to set
     */
    public PoiService(PoiRepository poiRepository){
        this.poiRepository = poiRepository;
    }

    /**
     * @see PoiService#getAllPoi()
     *
     * @return list of Points of Interest
     */
    public Flux<PointOfInterest> getAllPoi(){
        return poiRepository.findAll();
    }

    /**
     * @see PoiService#getOnlyOnePoi(Integer)
     *
     * @param id the Point Of Interest id
     *
     * @return the Point Of Interest with that id
     */
    public Mono<PointOfInterest> getOnlyOnePoi(Integer id){
        return poiRepository.findById(id);
    }

    /**
     * @see PoiService#addNewPoi(PointOfInterest)
     *
     * @param pointOfInterest the new Point Of Interest
     *
     * @return the added Point Of Interest
     */
    public Mono<PointOfInterest> addNewPoi(PointOfInterest pointOfInterest){
        return poiRepository.save(pointOfInterest);
    }

    /**
     * @see PoiService#deleteOnlyOnePoi(Integer)
     *
     * @param id the Point Of Interest to delete
     *
     * @return an empty mono
     */
    public Mono<Void> deleteOnlyOnePoi(Integer id){
       /*Mono<PointOfInterest> pointOfInterestMono = getOnlyOnePoi(id);
       pointOfInterestMono.flatMap(pointOfInterest1 ->
           poiRepository.deleteById(id));

       return Mono.empty();*/
        return poiRepository.deleteById(id);
    }

    /**
     * @see PoiService#deleteAllPoi()
     *
     * @return an empty mono
     */
    public Mono<Void> deleteAllPoi(){
        return poiRepository.deleteAll();
    }

    /**
     * @see PoiService#updatePoi(Integer, PointOfInterest)
     *
     * @param id the id to the Point Of Interest to update
     * @param pointOfInterest the updates to do
     *
     * @return the Point of Interest updated
     */
    public Mono<PointOfInterest> updatePoi(Integer id, PointOfInterest pointOfInterest){
        Mono<PointOfInterest> pointOfInterestMono = getOnlyOnePoi(id);
        pointOfInterest.setId(id);
        return pointOfInterestMono.flatMap(pointOfInterest1 -> poiRepository.save(pointOfInterest));
    }
}
