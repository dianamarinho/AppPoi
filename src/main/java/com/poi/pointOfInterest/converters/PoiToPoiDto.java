package com.poi.pointOfInterest.converters;

import com.poi.pointOfInterest.domain.PointOfInterest;
import com.poi.pointOfInterest.dto.PointOfInterestDto;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
/**
 * A {@link Converter} implementation, responsible for {@link PointOfInterest} to {@link PointOfInterestDto} tupe conversion
 */
@Component
public class PoiToPoiDto {

    /**
     * Converts Point Of Interest into Point Of Interest DTO
     *
     * @param pointOfInterest the Point Of Interest
     *
     * @return the Point Of Interest DTO
     */
    public PointOfInterestDto convertPoiIntoPoiDto(PointOfInterest pointOfInterest){

        PointOfInterestDto pointOfInterestDto = new PointOfInterestDto();

        pointOfInterestDto.setId(pointOfInterest.getId());
        pointOfInterestDto.setName(pointOfInterest.getName());
        pointOfInterestDto.setAddressName(pointOfInterest.getAddressName());
        pointOfInterestDto.setCity(pointOfInterest.getCity());
        pointOfInterestDto.setZipCode(pointOfInterest.getZipCode());
        pointOfInterestDto.setPoiType(pointOfInterest.getPoiType());

        return pointOfInterestDto;
    }
}
