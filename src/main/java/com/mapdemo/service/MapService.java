package com.mapdemo.service;

import com.mapdemo.model.MapPoint;

import java.util.List;

public interface MapService {
    List<MapPoint> getAllMapPoint();

    public void setMapPoint(MapPoint mapPoint);

    public void delMapPointById(int id);

    public MapPoint getMapPointById(int id);

    public void updateMapPoint(MapPoint mapPoint);
}
