package com.example.service;

import com.example.entity.SwMerchant;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商户表 服务类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
public interface SwMerchantService extends IService<SwMerchant> {

    List<SwMerchant> getMerchantByName(String merchantName);
}
