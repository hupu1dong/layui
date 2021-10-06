package com.zgy.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgy.layui.entity.AirQuality;
import com.zgy.layui.entity.Goods;
import com.zgy.layui.vo.GoodsVO;
import com.zgy.layui.vo.QualityLVO;
import com.zgy.layui.vo.QualityVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 18:59
 */
public interface AirQualityMapper extends BaseMapper<AirQuality> {
    @Select("SELECT city,AVG(pm) avg FROM air_quality WHERE city REGEXP '合肥|黄山|芜湖' GROUP BY city;")
    public List<QualityVO> findAllQualityBarVO();

    @Select("SELECT date,city,pm from air_quality;")
    public List<QualityLVO> findAllQualityLineVO();


}
