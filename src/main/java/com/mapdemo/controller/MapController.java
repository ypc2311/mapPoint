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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mapdemo.util.Statics;

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
    @RequestMapping(value="/getAllMapPoint")
    public Map<String,Object> getAllMapPoint(){
        Map<String,Object> result =new HashMap<String,Object>();
        result.put("code",Statics.RESULT_FAILURE);
        result.put("msg","请求失败");
        String mapPointsStr = "";
        try {
            List<MapPoint> mapPoints =  mapServiceImpl.getAllMapPoint();
            mapPointsStr = JSON.toJSONString(mapPoints);
            result.put("code",Statics.RESULT_SUCCESS);
            result.put("msg","请求成功");
            result.put("data",mapPointsStr);
        } catch (Exception e) {
            logger.debug("#getAllMapPoint:" + e.getMessage());
        }
        return result;
    }
    @RequestMapping("/setMapPoint")
    public Map<String,Object> setMapPoint(HttpServletRequest request){
        Map<String,Object> result =new HashMap<String,Object>();
        result.put("code",Statics.RESULT_FAILURE);
        result.put("msg","请求失败");
        String id = request.getParameter("id");
        int code = 0;
        String timestamp = DateUtil.getTimestamp();
        String timestampName = "HW"+timestamp.substring(timestamp.length()-5, timestamp.length());

        String name = request.getParameter("name") != null ? request.getParameter("name") : timestampName;
        String icon = request.getParameter("icon");
        String pointLat = request.getParameter("pointLat");
        String pointLng = request.getParameter("pointLng");
        String str1 = request.getParameter("str1");
        String str2 = request.getParameter("str2");
        String text = request.getParameter("text");
        MapPoint point = new MapPoint();
        point.setName(id);
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
            code = mapServiceImpl.setMapPoint(point);
        } catch (Exception e) {
            logger.debug("#setMapPoint:" + e.getMessage());
        }
        if(code > 0) {
            result.put("code", Statics.RESULT_SUCCESS);
            result.put("msg", "请求成功");
            result.put("data", point);
        }
        return result;
    }

    @RequestMapping(value="/getMapPointById",produces="text/html;charset=UTF-8")
    public Map<String,Object> getMapPoint(HttpServletRequest request){
        Map<String,Object> result =new HashMap<String,Object>();
        result.put("code",Statics.RESULT_FAILURE);
        result.put("msg","请求失败");
        String id = request.getParameter("id");
        if(id != null && !"".equals(id)){
            MapPoint point = mapServiceImpl.getMapPointById(Integer.parseInt(id));
            result.put("code",Statics.RESULT_SUCCESS);
            result.put("msg","请求成功");
            result.put("data",point.toString());
            return result;
        }
        return result;
    }

    @RequestMapping(value="/getMapPointByName",produces="text/html;charset=UTF-8")
    public Map<String,Object> getMapPointByName(HttpServletRequest request){
        Map<String,Object> result =new HashMap<String,Object>();
        result.put("code",Statics.RESULT_FAILURE);
        result.put("msg","请求失败");
        String name = request.getParameter("name");
        if(name != null && !"".equals(name)){
            MapPoint point = mapServiceImpl.getMapPointByName(name);
            result.put("code",Statics.RESULT_SUCCESS);
            result.put("msg","请求成功");
            result.put("data",point.toString());
            return result;
        }
        return result;
    }

    @RequestMapping("/updateMapPoint")
    public Map<String,Object> updateMapPoint(HttpServletRequest request){
        Map<String,Object> result =new HashMap<String,Object>();
        result.put("code",Statics.RESULT_FAILURE);
        result.put("msg","更新失败");
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
                int code = mapServiceImpl.updateMapPoint(point);
                if(code == 1) {
                    result.put("code", Statics.RESULT_SUCCESS);
                    result.put("msg", "更新成功");
                }
            } catch (Exception e) {
                logger.debug("#updateMapPoint:" + e.getMessage());
            }
            return result;
        }
        return result;
    }

    @RequestMapping("/delMapPointById")
    public Map<String,Object> delMapPointById(HttpServletRequest request){
        Map<String,Object> result =new HashMap<String,Object>();
        result.put("code",Statics.RESULT_FAILURE);
        result.put("msg","删除失败");
        String id = request.getParameter("id");
        if(id != null && !"".equals(id)){
            try {
                int code = mapServiceImpl.delMapPointById(Integer.parseInt(id));
                if(code == 1){
                    result.put("code",Statics.RESULT_FAILURE);
                    result.put("msg","删除成功");
                }
            } catch (Exception e) {
                logger.debug("#updateMapPoint:" + e.getMessage());
            }
        }
        return result;
    }
    @RequestMapping("/delMapPointByName")
    public Map<String,Object> delMapPointByName(HttpServletRequest request){
        Map<String,Object> result =new HashMap<String,Object>();
        result.put("code",Statics.RESULT_FAILURE);
        result.put("msg","删除失败");
        String name = request.getParameter("name");
        if(name != null && !"".equals(name)){
            try {
                int code = mapServiceImpl.delMapPointByName(name);
                if(code == 1){
                    result.put("code",Statics.RESULT_FAILURE);
                    result.put("msg","删除成功");
                }
            } catch (Exception e) {
                logger.debug("#updateMapPoint:" + e.getMessage());
            }
        }
        return result;
    }
}
