package com.mapdemo.service;

import com.mapdemo.model.MapPoint;

import java.util.List;

public interface MapService {
    List<MapPoint> getAllMapPoint();

    public int setMapPoint(MapPoint mapPoint);

    public int delMapPointById(int id);

    public int delMapPointByName(String name);

    public MapPoint getMapPointById(int id);

    public MapPoint getMapPointByName(String name);

    public int updateMapPoint(MapPoint mapPoint);
}
