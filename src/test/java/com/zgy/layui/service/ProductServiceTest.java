package com.zgy.layui.service;

import com.zgy.layui.vo.BarVO;
import com.zgy.layui.vo.DataVO;
import com.zgy.layui.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    void findData(){
//        DataVO dataVO = service.findData();
        int i = 0;

    }

    @Test
    void test(){
        BarVO barVO = service.getBarVO();
        int i = 0;
    }

}