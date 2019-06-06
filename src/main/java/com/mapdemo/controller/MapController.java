package com.mapdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapdemo.model.MyFile;
import com.mapdemo.model.MapPoint;
import com.mapdemo.service.impl.MapServiceImpl;
import com.mapdemo.util.DateUtil;
import com.mapdemo.util.FastDFSClient;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import com.mapdemo.util.Statics;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFast(HttpServletRequest request)throws Exception {
        MultipartHttpServletRequest multipartRequest = null;
        List<MultipartFile> files = new ArrayList<MultipartFile>();
        String filePath = "";
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)) {
            try {
                multipartRequest = (MultipartHttpServletRequest)request;
                files = multipartRequest.getFiles("file");
                // 获取文件map集合
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                System.out.println("files：" + files);
                System.out.println("fileMap：" + fileMap);
            } catch (Exception e) {
                return new LinkedList<MultipartFile>().toString();
            }
        }
        String confUrl = this.getClass().getClassLoader().getResource("/fdfs_client.properties").getPath();
        FastDFSClient fastDFSClient = new FastDFSClient(confUrl);

        List<MyFile> myFilePaths = new ArrayList<MyFile>();
        for(MultipartFile file:files){
            String fileNameStr = file.getOriginalFilename();
            String  fileType = fileNameStr.substring(fileNameStr.indexOf(".")+1,fileNameStr.length());
            String  fileName = fileNameStr.substring(0,fileNameStr.indexOf(".")-1);
            byte[] fileByte = file.getBytes();
            long fileSize = file.getSize();
            String fileExtName = fileNameStr.substring(fileNameStr.lastIndexOf("."));
            //设置元信息
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", fileName);
            metaList[1] = new NameValuePair("fileExtName", fileExtName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(fileSize));
            //上传文件
            try {
                //logger.info("fastDFSClient.uploadFile start confUrl =>"+e.getMessage());
                filePath = fastDFSClient.uploadFile(fileByte,fileType,metaList);
            }catch (Exception e){
                logger.info("fastDFSClient.uploadFile e =>"+e.getMessage());
            }
            MyFile myFile = new MyFile();
            myFile.setFileName(fileName);
            myFile.setFileSize(fileSize);
            myFile.setFileType(fileType);
            myFile.setFilePath(filePath);
            myFilePaths.add(myFile);
        }
        String fileJsons = JSON.toJSONString(myFilePaths);
        return fileJsons;
    }
}
