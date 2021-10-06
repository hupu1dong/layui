package com.zgy.layui.vo;

import lombok.Data;

import java.util.List;

/**
 * vo即为view object 当前端要求的数据与后端提供的不一致时使用
 */
@Data
public class BarVO {
    private List<String> names;
    private List<Integer> values;
}
