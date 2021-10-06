package com.zgy.layui.service;

import com.zgy.layui.entity.Goods;
import com.zgy.layui.vo.BarVO;
import com.zgy.layui.vo.GoodsVO;
import com.zgy.layui.vo.PieVO;
import com.zgy.layui.vo.ProductVO;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 11:35
 */
public interface GoodsService {
    public void insert(List<Goods> goodsList);
    public BarVO getBarVO();

    List<PieVO> getPieVO();
}
