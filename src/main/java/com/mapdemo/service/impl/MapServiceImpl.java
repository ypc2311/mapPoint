package com.mapdemo.service.impl;

import com.mapdemo.model.MapPoint;
import com.mapdemo.dao.MapMapper;
import com.mapdemo.service.MapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * MapServiceImpl
 *
 * @author ypc
 * @date 2019/05/09
 */

@Service(value = "mapService")
public class MapServiceImpl implements MapService {
    @Resource
    private MapMapper mapMapper;

    @Override
    public  List<MapPoint> getAllMapPoint(){
        return mapMapper.getAllMapPoint();
    }
    @Override
    public int setMapPoint(MapPoint mapPoint) {
        return mapMapper.insertMapPoint(mapPoint);
    }
    @Override
    public int delMapPointById(int id) {
        return mapMapper.deleteMapPointById(id);
    }
    @Override
    public int delMapPointByName(String name) {
        return mapMapper.deleteMapPointByName(name);
    }
    @Override
    public MapPoint getMapPointById(int id) {
        return mapMapper.selectMapPointById(id);
    }
    @Override
    public MapPoint getMapPointByName(String name) {
        return mapMapper.selectMapPointByName(name);
    }
    @Override
    public int updateMapPoint(MapPoint mapPoint) {
        return mapMapper.updateMapPoint(mapPoint);
    }
}
