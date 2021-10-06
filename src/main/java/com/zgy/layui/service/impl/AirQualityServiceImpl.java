package com.zgy.layui.service.impl;

import com.zgy.layui.entity.AirQuality;
import com.zgy.layui.entity.Goods;
import com.zgy.layui.mapper.AirQualityMapper;
import com.zgy.layui.mapper.GoodsMapper;
import com.zgy.layui.service.AirQualityService;
import com.zgy.layui.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 19:02
 */
@Service
public class AirQualityServiceImpl implements AirQualityService {
    @Autowired
    private AirQualityMapper airQualityMapper;
    @Override
    public void insert(List<AirQuality> qualityList) {
        for (AirQuality quality : qualityList) {
            AirQuality airQuality = new AirQuality();
            airQuality.setDate(quality.getDate());
            airQuality.setRegion(quality.getRegion());
            airQuality.setCity(quality.getCity());
            airQuality.setPm(quality.getPm());
            airQualityMapper.insert(airQuality);
        }
    }

    @Override
    public QualityBarVO getBarVO() {
        List<QualityVO> list = airQualityMapper.findAllQualityBarVO();
        List<String> citys = new ArrayList<>();
        List<Double> avgPms = new ArrayList<>();
        for (QualityVO qualityVO : list) {
            citys.add(qualityVO.getCity());
            avgPms.add(qualityVO.getAvg());
        }
        QualityBarVO qualityBarVO = new QualityBarVO();
        qualityBarVO.setCitys(citys);
        qualityBarVO.setAvgPms(avgPms);
        return qualityBarVO;
    }

    @Override
    public QualityLineVO getLineVO() {
        List<QualityLVO> list = airQualityMapper.findAllQualityLineVO();
        List<Date> dates = new ArrayList<>();
        List<String> citys = new ArrayList<>();
        List<Integer> pms = new ArrayList<>();
        for (QualityLVO lvo : list) {
            dates.add(lvo.getDate());
            citys.add(lvo.getCity());
            pms.add(lvo.getPm());
        }
        QualityLineVO lineVO = new QualityLineVO();
        lineVO.setCitys(citys);
        lineVO.setDates(dates);
        lineVO.setPms(pms);
        return lineVO;
    }
}
