package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.SwComments;
import com.example.mapper.SwCommentsMapper;
import com.example.service.SwCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评价表 服务实现类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-12
 */
@Service
public class SwCommentsServiceImpl extends ServiceImpl<SwCommentsMapper, SwComments> implements SwCommentsService {

    @Autowired
    private SwCommentsMapper swCommentsMapper;
    /**
     * @param userId
     * @return
     */
    @Override
    public List<SwComments> queryCommentsByUserId(Long userId) {
        return swCommentsMapper.queryCommentsByUserId(userId);
    }

    /**
     * @param foodId
     * @param merchantId
     * @return
     */
    @Override
    public List<SwComments> queryCommentsByFoodIdAndMerchantId(Long foodId, Long merchantId) {
        return swCommentsMapper.queryCommentsByFoodIdAndMerchantId(foodId,merchantId);
    }
}
