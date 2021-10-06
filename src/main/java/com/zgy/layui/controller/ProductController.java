package com.zgy.layui.controller;

import com.zgy.layui.entity.Goods;
import com.zgy.layui.mapper.GoodsMapper;
import com.zgy.layui.mapper.ProductMapper;
import com.zgy.layui.service.GoodsService;
import com.zgy.layui.service.ProductService;
import com.zgy.layui.txt2Mysql.DataOperation;
import com.zgy.layui.vo.BarVO;
import com.zgy.layui.vo.DataVO;
import com.zgy.layui.vo.PieVO;
import com.zgy.layui.vo.ProductBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;


    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page,Integer limit){
        return productService.findData(page,limit);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/barVO")
    @ResponseBody
    public BarVO getBarVO(){
        return productService.getBarVO();
    }

    @RequestMapping("/pieVO")
    @ResponseBody
    public List<PieVO> getPieVO(){
        return productService.getPieVO();
    }



//    @RequestMapping("/pieVO")
//    @ResponseBody
//    public List<ProductBarVO> getPieVO(){
//        return productMapper.findAllProductBarVO();
//    }

}
