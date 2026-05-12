package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.SwOrderItem;

import java.util.List;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
public interface SwOrderItemMapper extends BaseMapper<SwOrderItem> {

    List<SwOrderItem> findOrderItemByOrderId(String orderNo);
}
