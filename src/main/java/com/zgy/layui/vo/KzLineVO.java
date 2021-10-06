package com.zgy.layui.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/11 11:17
 */
@Data
public class KzLineVO {
    private List<String> monthas;
    private List<Double> consumSums;
    private List<Long> consumNums;
}
