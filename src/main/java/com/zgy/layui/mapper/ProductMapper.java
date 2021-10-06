package com.zgy.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgy.layui.entity.Product;
import com.zgy.layui.vo.ProductBarVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT name,SUM(quantity) count FROM order_detail o,product p WHERE o.product_id=p.id GROUP BY product_id")
    public List<ProductBarVO> findAllProductBarVO();
}
