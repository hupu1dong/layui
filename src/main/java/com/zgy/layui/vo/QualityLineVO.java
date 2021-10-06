package com.zgy.layui.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/10 0:03
 */
@Data
public class QualityLineVO {
    private List<Date> dates;
    private List<String> citys;
    private List<Integer> pms;
}
