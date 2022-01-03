package com.poi.pointOfInterest.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PointOfInterestDtoTest {

    @Test
    void testToString() {
        PointOfInterestDto pointOfInterestDto = new PointOfInterestDto();
        pointOfInterestDto.setName("Diana");

        String expectedId = "Diana";

        assertEquals(expectedId, pointOfInterestDto.getName());
    }

    @Test
    void testHashCode() {
        PointOfInterestDto pointOfInterestDto = new PointOfInterestDto();
        pointOfInterestDto.setId(1);

        PointOfInterestDto pointOfInterestDto1 = new PointOfInterestDto();
        pointOfInterestDto1.setId(1);

        assertEquals(pointOfInterestDto, pointOfInterestDto1);
    }
}