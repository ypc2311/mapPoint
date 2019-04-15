package com.mapdemo.service.impl;

import com.mapdemo.model.MapPoint;
import com.mapdemo.dao.MapMapper;
import com.mapdemo.service.MapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "mapService")
public class MapServiceImpl implements MapService {
    @Resource
    private MapMapper mapMapper;

    @Override
    public  List<MapPoint> getAllMapPoint(){
        return mapMapper.getAllMapPoint();
    }
    public void setMapPoint(MapPoint mapPoint) {
        mapMapper.insertMapPoint(mapPoint);
    }
    public void delMapPointById(int id) {
        mapMapper.deleteMapPointById(id);
    }
    public MapPoint getMapPointById(int id) {
        return mapMapper.selectMapPointById(id);
    }
    public void updateMapPoint(MapPoint mapPoint) {
        mapMapper.updateMapPoint(mapPoint);
    }
}
