package com.zgy.layui.controller;

import com.zgy.layui.entity.AirQuality;
import com.zgy.layui.entity.Goods;
import com.zgy.layui.entity.Kz;
import com.zgy.layui.mapper.AirQualityMapper;
import com.zgy.layui.mapper.GoodsMapper;
import com.zgy.layui.mapper.KzMapper;
import com.zgy.layui.service.AirQualityService;
import com.zgy.layui.service.GoodsService;
import com.zgy.layui.service.KzService;
import com.zgy.layui.txt2Mysql.DataOperation;
import com.zgy.layui.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.text.ParseException;
import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 13:26
 */
@Controller
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private AirQualityService qualityService;
    @Autowired
    private AirQualityMapper airQualityMapper;

    @Autowired
    private KzService kzService;
    @Autowired
    private KzMapper kzMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);


    @RequestMapping("/goodsBarVO")
    @ResponseBody
    public BarVO getBarVO(){
        return goodsService.getBarVO();
    }

    @RequestMapping("/goodsPieVO")
    @ResponseBody
    public List<PieVO> getPieVO(){
        return goodsService.getPieVO();
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        InputStream inputStream = file.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //存储到数据库中
        List<Goods> list = new DataOperation().getGoodsObject(inputStreamReader);
        goodsService.insert(list);

        String fileName = file.getOriginalFilename();
        String filePath = "D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\temp\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @GetMapping("/uploadAir")
    public String uploadAir() {
        return "uploadAir";
    }
    @PostMapping("/uploadAir")
    @ResponseBody
    public String uploadAir(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        InputStream inputStream = file.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //存储到数据库中
        List<AirQuality> list = new DataOperation().getAirQualityObject(inputStreamReader);
        qualityService.insert(list);

        String fileName = file.getOriginalFilename();
        String filePath = "D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\temp\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @GetMapping("/uploadKZ")
    public String uploadKZ() {
        return "uploadKZ";
    }

    @PostMapping("/uploadKZ")
    @ResponseBody
    public String uploadKZ(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        InputStream inputStream = file.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //存储到数据库中
        List<Kz> list = new DataOperation().getKZObject(inputStreamReader);
        kzService.insert(list);

        String fileName = file.getOriginalFilename();
        String filePath = "D:\\FlinkProjects\\testTom\\demo\\layui\\src\\main\\java\\com\\zgy\\layui\\txt2Mysql\\temp\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @RequestMapping("/qualityBarVO")
    @ResponseBody
    public QualityBarVO getqualityBarVO(){
        return qualityService.getBarVO();
    }

    @RequestMapping("/qualityLineVO")
    @ResponseBody
    public QualityLineVO getqualityLineVO(){
        return qualityService.getLineVO();
    }

    @RequestMapping("/KzScatterVO")
    @ResponseBody
    public KzLineVO ScatterVO(){
        return kzService.getScatter();
    }

}
