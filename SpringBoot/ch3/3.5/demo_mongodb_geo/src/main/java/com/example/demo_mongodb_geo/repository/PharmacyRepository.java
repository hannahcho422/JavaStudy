package com.example.demo_mongodb_geo.repository;

import java.util.List;

import com.example.demo_mongodb_geo.model.Pharmacy;
  
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Polygon;

@Repository
public interface PharmacyRepository extends MongoRepository<Pharmacy, String> {
    // point 기준으로 distance 거리 이내에 있는 약국 검색
    List<Pharmacy> findByLocationNear(Point point, Distance distance);

    // polygon 영역 이내에 있는 약국 검색
    List<Pharmacy> findByLocationWithin(Polygon polygon);
}
