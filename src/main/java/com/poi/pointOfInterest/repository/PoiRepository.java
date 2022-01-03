package com.poi.pointOfInterest.repository;

import com.poi.pointOfInterest.domain.PointOfInterest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepository extends ReactiveCrudRepository<PointOfInterest, Integer> {
}
