package com.zgy.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgy.layui.entity.Goods;
import com.zgy.layui.vo.GoodsVO;
import com.zgy.layui.vo.ProductBarVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 11:25
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("SELECT evaluation,count(evaluation) count FROM goods  GROUP BY evaluation;")
    public List<GoodsVO> findAllGoodsBarVO();
}
