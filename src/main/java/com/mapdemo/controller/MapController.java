package com.mapdemo.controller;

import com.alibaba.fastjson.JSON;
import com.mapdemo.model.MapPoint;
import com.mapdemo.service.impl.MapServiceImpl;
import com.mapdemo.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * MapController class
 *
 * @author ypc
 * @date 2019/04/19
 */
@RestController
public class MapController {
    @Resource
    private MapServiceImpl mapServiceImpl;
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    @RequestMapping(value="/getAllMapPoint",produces="text/html;charset=UTF-8")
    public String getAllMapPoint(){
        String mapPointsStr = "";
        try {
            List<MapPoint> mapPoints =  mapServiceImpl.getAllMapPoint();
            mapPointsStr = JSON.toJSONString(mapPoints);
        } catch (Exception e) {
            logger.debug("#getAllMapPoint:" + e.getMessage());
        }
        return mapPointsStr;
    }
    @RequestMapping("/setMapPoint")
    public String setMapPoint(HttpServletRequest request){
        String timestamp = DateUtil.getTimestamp();
        String timestampName = "洪武"+timestamp.substring(timestamp.length()-5, timestamp.length());

        String name = request.getParameter("name") != null ? request.getParameter("name") : timestampName;
        String icon = request.getParameter("icon");
        String pointLat = request.getParameter("pointLat");
        String pointLng = request.getParameter("pointLng");
        String str1 = request.getParameter("str1");
        String str2 = request.getParameter("str2");
        String text = request.getParameter("text");
        MapPoint point = new MapPoint();
        point.setName(name);
        point.setIcon(icon);
        point.setStatus(1);
        point.setPointLat(pointLat);
        point.setPointLng(pointLng);
        point.setStr1(str1);
        point.setStr2(str2);
        point.setCreateTime(DateUtil.getDateTime());
        point.setUpdateTime(DateUtil.getDateTime());
        point.setText(text);
        try {
            mapServiceImpl.setMapPoint(point);
        } catch (Exception e) {
            logger.debug("#setMapPoint:" + e.getMessage());
        }
        return "";
    }

    @RequestMapping(value="/getMapPointById",produces="text/html;charset=UTF-8")
    public String getMapPoint(HttpServletRequest request){
        String id = request.getParameter("id");
        if(id != null && !"".equals(id)){
            MapPoint point = mapServiceImpl.getMapPointById(Integer.parseInt(id));
            return JSON.toJSONString(point);
        }else{
            return "1";
        }
    }

    @RequestMapping("/updateMapPoint")
    public String updateMapPoint(HttpServletRequest request){
        MapPoint point = new MapPoint();
        String id = request.getParameter("id");
        if(id != null && !"".equals(id)){
            String icon = request.getParameter("icon");
            String pointLat = request.getParameter("pointLat");
            String pointLng = request.getParameter("pointLng");
            String status = request.getParameter("status") != null ? request.getParameter("name") : "2";
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            String text = request.getParameter("text");
            point.setId(Integer.parseInt(id));
            point.setIcon(icon);
            point.setStatus(Integer.parseInt(status));
            point.setPointLat(pointLat);
            point.setPointLng(pointLng);
            point.setStr1(str1);
            point.setStr2(str2);
            point.setUpdateTime(DateUtil.getDateTime());
            point.setText(text);
            try {
                mapServiceImpl.updateMapPoint(point);
            } catch (Exception e) {
                logger.debug("#updateMapPoint:" + e.getMessage());
            }
            return "0";
        }else{
            return "1";
        }
    }

    @RequestMapping("/delMapPoint")
    public String delMapPoint(HttpServletRequest request){
        String id = request.getParameter("id");
        if(id != null && !"".equals(id)){
            try {
                mapServiceImpl.delMapPointById(Integer.parseInt(id));

            } catch (Exception e) {
                logger.debug("#updateMapPoint:" + e.getMessage());
            }
            return "0";
        }else{
            return "1";
        }
    }
}
