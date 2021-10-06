package com.zgy.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgy.layui.entity.Kz;
import com.zgy.layui.vo.KzLine;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/11 10:28
 */
public interface KzMapper extends BaseMapper<Kz> {
    @Select("SELECT user_id,sum(price) sp,count(event_type) ce from kz GROUP BY user_id;")
    public List<KzLine> findAllKzScatterVO();

}
