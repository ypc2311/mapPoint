package com.map.mapdemo.dao;

import com.map.mapdemo.model.MapPoint;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapMapper {
    List<MapPoint> getAllMapPoint();
}
