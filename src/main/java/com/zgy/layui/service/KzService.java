package com.zgy.layui.service;

import com.zgy.layui.entity.Kz;
import com.zgy.layui.vo.KzLineVO;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/11 10:28
 */
public interface KzService {
    public void insert(List<Kz> KzList);

    public KzLineVO getScatter();
}
