package com.mapdemo.dao;

import com.mapdemo.model.MapPoint;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MapMapper {
    List<MapPoint> getAllMapPoint();
    public int insertMapPoint(MapPoint mapPoint);
    public int deleteMapPointById(int id);
    public int deleteMapPointByName(String id);
    public MapPoint selectMapPointById(int id);
    public MapPoint selectMapPointByName(String name);
    public int updateMapPoint(MapPoint mapPoint);
}
