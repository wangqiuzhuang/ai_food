package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.SwComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评价表 Mapper 接口
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-12
 */
public interface SwCommentsMapper extends BaseMapper<SwComments> {

    List<SwComments> queryCommentsByUserId(Long userId);

    List<SwComments> queryCommentsByFoodIdAndMerchantId(
            @Param("foodId") Long foodId,
            @Param("merchantId") Long merchantId
    );}
