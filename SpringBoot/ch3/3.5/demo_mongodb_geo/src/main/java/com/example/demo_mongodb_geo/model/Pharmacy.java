package com.example.demo_mongodb_geo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.geo.Point;

import lombok.Builder;
import lombok.Data;

@Document
@Data
@Builder
public class Pharmacy {
    @Id
    private String id;
    private String name;
    private String phone;
    private String address;
    // 위치 기반의 검색을 빠르게 하기 위해 location 프로퍼티에 지구의 곡률을 반영한 인덱스 생성
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Point location;
}
