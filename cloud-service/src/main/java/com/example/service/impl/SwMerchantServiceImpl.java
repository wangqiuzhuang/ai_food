package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.SwMerchant;
import com.example.mapper.SwMerchantMapper;
import com.example.service.SwMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商户表 服务实现类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Service
public class SwMerchantServiceImpl extends ServiceImpl<SwMerchantMapper, SwMerchant> implements SwMerchantService {

    @Autowired
    private SwMerchantMapper swMerchantMapper;
    /**
     * @param merchantName
     * @return
     */
    @Override
    public List<SwMerchant> getMerchantByName(String merchantName) {
        return swMerchantMapper.getMerchantByName(merchantName);
    }

    /**
     * @param merchantClass
     * @return
     */
    @Override
    public List<SwMerchant> findByClass(Integer merchantClass) {
        return swMerchantMapper.findByClass(merchantClass);
    }
}
