package com.mapdemo.dao;

import com.mapdemo.model.MapPoint;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MapMapper {
    List<MapPoint> getAllMapPoint();
    public void insertMapPoint(MapPoint mapPoint);
    public void deleteMapPointById(int id);
    public MapPoint selectMapPointById(int id);
    public void updateMapPoint(MapPoint mapPoint);
}
