package com.example.service.impl;

import com.example.entity.SwOrder;
import com.example.mapper.SwOrderMapper;
import com.example.returns.R;
import com.example.service.SwOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Service
public class SwOrderServiceImpl extends ServiceImpl<SwOrderMapper, SwOrder> implements SwOrderService {

    @Autowired
    private SwOrderMapper swOrderMapper;
    /**
     * @return
     */
    @Override
    public List<SwOrder> findByUserId(Long userId) {
        return swOrderMapper.findByUserId(userId);
    }
}
