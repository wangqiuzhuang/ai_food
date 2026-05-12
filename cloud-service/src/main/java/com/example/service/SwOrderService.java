package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.SwOrder;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
public interface SwOrderService extends IService<SwOrder> {

    List<SwOrder> findByUserId(Long userId);
}
