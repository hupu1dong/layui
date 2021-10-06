package com.zgy.layui.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/9 18:46
 */
@Data
public class AirQuality {
    private Date date;
    private Integer pm;
    private String city;
    private String region;
}
