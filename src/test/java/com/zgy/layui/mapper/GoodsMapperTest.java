package com.zgy.layui.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 14:36
 */
@SpringBootTest
@MapperScan("com.zgy.layui.mapper")
class GoodsMapperTest {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void test(){
        goodsMapper.selectList(null).forEach(System.out::println);
    }

}