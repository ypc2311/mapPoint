package com.mapdemo.controller;

import com.mapdemo.model.MapPoint;
import com.mapdemo.service.impl.MapServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MapController {
    @Resource
    private MapServiceImpl mapServiceImpl;

    @RequestMapping("/getAllMapPoint.do")
    public String getAllMapPoint(){
        String mapPointsStr = "";
        List<MapPoint> mapPoints =  mapServiceImpl.getAllMapPoint();
        mapPointsStr = mapPoints.toString();
        return mapPointsStr;
    }
    @RequestMapping("/setMapPoint.do")
    public String setMapPoint(MapPoint point){
        point.setName("1ka1");
        point.setIcon("11");
        point.setPointLat("11");
        point.setPointLng("11");
        point.setStr1("11");
        point.setStr2("11");
        point.setCreateTime("11");
        point.setUpdateTime("11");
        point.setText("101");
        mapServiceImpl.setMapPoint(point);
        return "";
    }

    @RequestMapping("/getMapPointById.do")
    public String getMapPoint(int id){
        MapPoint point = mapServiceImpl.getMapPointById(id);
        return point.toString();
    }

    @RequestMapping("/updateMapPoint.do")
    public String updateMapPoint(int id){
        MapPoint point = new MapPoint();
        point.setId(id);
        point.setName("66");
        point.setIcon("6");
        point.setPointLat("6");
        point.setPointLng("6");
        point.setStr1("6");
        point.setStr2("6");
        point.setCreateTime("6");
        point.setUpdateTime("6");
        point.setText("6");
        mapServiceImpl.updateMapPoint(point);
        return point.toString();
    }

    @RequestMapping("/delMapPoint.do")
    public String delMapPoint(int id){
        mapServiceImpl.delMapPointById(id);
        return "";
    }
}
