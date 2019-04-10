package com.map.mapdemo.controller;

import com.map.mapdemo.entity.MapPoint;
import com.map.mapdemo.service.MapService;
import com.map.mapdemo.service.impl.MapServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.map.mapdemo.service.MapService.*;

@RestController
@EnableAutoConfiguration
public class MapController {
    @RequestMapping("/getAllMapPoint")
    public String index(){
        String mapPointsStr = null;
        MapService mapServiceImpl=new MapServiceImpl();
        List<MapPoint> mapPoints =  mapServiceImpl.getAllMapPoint();
        mapPointsStr = mapPoints.toString();

        return mapPointsStr;
    }
}
