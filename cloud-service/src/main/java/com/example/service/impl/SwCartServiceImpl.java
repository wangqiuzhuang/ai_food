package com.example.service.impl;

import com.example.entity.SwCart;
import com.example.mapper.SwCartMapper;
import com.example.service.SwCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Service
public class SwCartServiceImpl extends ServiceImpl<SwCartMapper, SwCart> implements SwCartService {

    @Autowired
    private SwCartMapper swCartMapper;
    /**
     * @param userId
     * @return
     */
    @Override
    public List<SwCart> findByUserId(Long userId) {
        return swCartMapper.findByUserId(userId);
    }
}
