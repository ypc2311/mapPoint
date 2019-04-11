package com.map.mapdemo.mapper;

import com.map.mapdemo.model.MapPoint;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface MapMapper {
    List<MapPoint> getAllMapPoint();
}
