package com.example.mapper;

import com.example.entity.SwFood;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 食品商品表 Mapper 接口
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
public interface SwFoodMapper extends BaseMapper<SwFood> {

    List<SwFood> findFoodByMerchantId(Long id);

    SwFood findFoodByFoodId(Long id);
}
