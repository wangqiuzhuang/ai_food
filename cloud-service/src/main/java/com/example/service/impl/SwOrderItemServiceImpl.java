package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.SwOrderItem;
import com.example.mapper.SwOrderItemMapper;
import com.example.service.SwOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Service
public class SwOrderItemServiceImpl extends ServiceImpl<SwOrderItemMapper, SwOrderItem> implements SwOrderItemService {

    @Autowired
    private SwOrderItemMapper swOrderItemMapper;
    /**
     * @param orderNo
     * @return
     */
    @Override
    public List<SwOrderItem> findOrderItemByOrderId(String orderNo) {
        return swOrderItemMapper.findOrderItemByOrderId(orderNo);
    }
}
