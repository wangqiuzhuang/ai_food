package com.example.service;

import com.example.entity.SwComments;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评价表 服务类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-12
 */
public interface SwCommentsService extends IService<SwComments> {

    List<SwComments> queryCommentsByUserId(Long userId);

    List<SwComments> queryCommentsByFoodIdAndMerchantId(Long foodId, Long merchantId);
}
