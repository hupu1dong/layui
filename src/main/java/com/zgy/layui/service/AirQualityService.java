package com.zgy.layui.service;

import com.zgy.layui.entity.AirQuality;
import com.zgy.layui.entity.Goods;
import com.zgy.layui.vo.BarVO;
import com.zgy.layui.vo.QualityBarVO;
import com.zgy.layui.vo.QualityLineVO;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 19:01
 */
public interface AirQualityService {
    public void insert(List<AirQuality> qualityList);
    public QualityBarVO getBarVO();
    public QualityLineVO getLineVO();
}
