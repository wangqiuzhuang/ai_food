package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.SwOrderItem;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
public interface SwOrderItemService extends IService<SwOrderItem> {

    List<SwOrderItem> findOrderItemByOrderId(String orderNo);
}
