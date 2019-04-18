package com.mapdemo.controller;

import com.mapdemo.model.MapPoint;
import com.mapdemo.service.impl.MapServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class MapController {
    @Resource
    private MapServiceImpl mapServiceImpl;

    @RequestMapping("/getAllMapPoint")
    public String getAllMapPoint(HttpServletRequest request){
        String mapPointsStr = "";
        List<MapPoint> mapPoints =  mapServiceImpl.getAllMapPoint();
        MapPoint mapPoints1 = mapPoints.get(0);
        JSONArray mapPointsJson = JSONArray.parseArray(mapPoints1.toString());
        mapPointsStr = mapPointsJson.toString();
        return mapPointsStr;
    }
    @RequestMapping("/setMapPoint")
    public String setMapPoint(HttpServletRequest request,String name,String pointLat,String pointLng){
        MapPoint point = new MapPoint();
        point.setName(name);
        point.setIcon("11");
        point.setPointLat(pointLat);
        point.setPointLng(pointLng);
        point.setStr1("11");
        point.setStr2("11");
        point.setCreateTime((new Date()).toString());
        point.setUpdateTime((new Date()).toString());
        point.setText("101");
        mapServiceImpl.setMapPoint(point);
        return "";
    }

    @RequestMapping("/getMapPointById")
    public String getMapPoint(int id){
        MapPoint point = mapServiceImpl.getMapPointById(id);
        return point.toString();
    }

    @RequestMapping("/updateMapPoint")
    public String updateMapPoint(HttpServletRequest request,String name,String pointLat,String pointLng,int id){
        MapPoint point = new MapPoint();
        point.setId(id);
        point.setName(name);
        point.setIcon("6");
        point.setPointLat(pointLat);
        point.setPointLng(pointLng);
        point.setStr1("6");
        point.setStr2("6");
        point.setUpdateTime((new Date()).toString());
        point.setText("6");
        mapServiceImpl.updateMapPoint(point);
        return point.toString();
    }

    @RequestMapping("/delMapPoint")
    public String delMapPoint(int id){
        mapServiceImpl.delMapPointById(id);
        return "";
    }
}
