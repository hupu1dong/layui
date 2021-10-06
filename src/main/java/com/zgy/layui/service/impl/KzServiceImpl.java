package com.zgy.layui.service.impl;

import com.zgy.layui.entity.Kz;
import com.zgy.layui.mapper.KzMapper;
import com.zgy.layui.service.KzService;
import com.zgy.layui.vo.KzLine;
import com.zgy.layui.vo.KzLineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/11 10:29
 */
@Service
public class KzServiceImpl implements KzService {
    @Autowired
    private KzMapper kzMapper;
    @Override
    public void insert(List<Kz> KzList) {
        for (Kz kz : KzList) {
//            Kz kzE = new Kz();
//            kzE.setUserId(kz.getUserId());
//            kzE.setBrandName(kz.getBrandName());
//            kzE.setCategoryCode(kz.getCategoryCode());
//            kzE.setMontha(kz.getMontha());
//            kzE.setPrice(kz.getPrice());
//            kzE.setEventType(kz.getEventType());
//            kzE.setProductId(kz.getProductId());
            kzMapper.insert(kz);
        }
    }

    @Override
    public KzLineVO getScatter() {
        List<KzLine> list = kzMapper.findAllKzScatterVO();
        List<Long> consumNums = new ArrayList<>();
        List<Double> consumSums = new ArrayList<>();
        for (KzLine scatter : list) {
            consumNums.add(scatter.getConsumNum());
            consumSums.add(scatter.getConsumSum());
        }
        KzLineVO scatterVO = new KzLineVO();
        scatterVO.setConsumNums(consumNums);
        scatterVO.setConsumSums(consumSums);
        return scatterVO;
    }
}
