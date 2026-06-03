package com.example.mapper;

import com.example.entity.SwMerchant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商户表 Mapper 接口
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
public interface SwMerchantMapper extends BaseMapper<SwMerchant> {

    List<SwMerchant> getMerchantByName(String merchantName);

    List<SwMerchant> findByClass(Integer merchantClass);
}
