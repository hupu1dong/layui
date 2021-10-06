package com.zgy.layui.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elasticsearch.client.license.LicensesStatus;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/30 15:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KzOneLineVO {
    private List<Long> userNums;
    private List<Double> cumPs;
}
