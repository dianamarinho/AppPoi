package com.poi.pointOfInterest.converters;

import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.dto.PointOfInterestDto;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

/**
 * A {@link Converter} implementation, responsible for {@link PointOfInterestDto} to {@link PointOfInterest} type conversion
 */
@Component
public class PoiDtoToPoi {

    /**
     * Converts the Point Of Interest DTO into a Point Of Interest domain object
     *
     * @param pointOfInterestDto the Point Of Interest DTO
     *
     * @return the Point Of Interest
     */
    public PointOfInterest convertPoiDtoIntoPoi(PointOfInterestDto pointOfInterestDto){

        PointOfInterest pointOfInterest = new PointOfInterest();

        pointOfInterest.setId(pointOfInterestDto.getId());
        pointOfInterest.setName(pointOfInterestDto.getName());
        pointOfInterest.setAddressName(pointOfInterestDto.getAddressName());
        pointOfInterest.setCity(pointOfInterestDto.getCity());
        pointOfInterest.setZipCode(pointOfInterestDto.getZipCode());
        pointOfInterest.setPoiType(pointOfInterestDto.getPoiType());

        return pointOfInterest;
    }
}
