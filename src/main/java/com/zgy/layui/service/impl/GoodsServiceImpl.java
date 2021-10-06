package com.zgy.layui.service.impl;

import com.zgy.layui.entity.Goods;
import com.zgy.layui.mapper.GoodsMapper;
import com.zgy.layui.mapper.ProductMapper;
import com.zgy.layui.service.GoodsService;
import com.zgy.layui.vo.BarVO;
import com.zgy.layui.vo.GoodsVO;
import com.zgy.layui.vo.PieVO;
import com.zgy.layui.vo.ProductBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 11:43
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void insert(List<Goods> goodsList) {
        for (Goods goods : goodsList) {
            Goods goodEntity = new Goods();
            goodEntity.setId(goods.getId());
            goodEntity.setEvaluation(goods.getEvaluation());
            int count = goodsMapper.insert(goodEntity);
        }
    }

    @Override
    public BarVO getBarVO() {
        List<GoodsVO> list = goodsMapper.findAllGoodsBarVO();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (GoodsVO goodsVO : list) {
            names.add(goodsVO.getEvaluation());
            values.add(goodsVO.getCount());
        }
        BarVO barVO = new BarVO();
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }

    @Override
    public List<PieVO> getPieVO() {
        List<GoodsVO> list = goodsMapper.findAllGoodsBarVO();
        List<PieVO> pieVOList = list.stream()
                .map(e -> new PieVO(
                        e.getCount(),
                        e.getEvaluation()
                )).collect(Collectors.toList());
        return pieVOList;
    }
}
