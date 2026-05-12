package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.SwFood;
import com.example.mapper.SwFoodMapper;
import com.example.service.SwFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 食品商品表 服务实现类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Service
public class SwFoodServiceImpl extends ServiceImpl<SwFoodMapper, SwFood> implements SwFoodService {

    @Autowired
    private SwFoodMapper swFoodMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public List<SwFood> findFoodByMerchantId(Long id) {
        return swFoodMapper.findFoodByMerchantId(id);
    }
}
