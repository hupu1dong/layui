package com.zgy.layui.service;

import com.zgy.layui.vo.BarVO;
import com.zgy.layui.vo.DataVO;
import com.zgy.layui.vo.PieVO;
import com.zgy.layui.vo.ProductVO;

import java.util.List;

public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);
    public BarVO getBarVO();
    public List<PieVO> getPieVO();
}
