package com.zgy.layui.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/11 11:17
 */
@Data
public class KzScatterVO {
    private List<String> userId;
    private List<Double> consumSums;
    private List<Long> consumNums;
}
