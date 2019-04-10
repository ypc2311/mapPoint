package com.map.mapdemo.service.impl;

import com.map.mapdemo.entity.MapPoint;
import com.map.mapdemo.mapper.MapMapper;
import com.map.mapdemo.service.MapService;
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
}
