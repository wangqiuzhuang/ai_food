package com.example.service.impl;

import com.example.entity.SwUser;
import com.example.mapper.SwUserMapper;
import com.example.service.SwUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Service
public class SwUserServiceImpl extends ServiceImpl<SwUserMapper, SwUser> implements SwUserService {


    @Autowired
    private SwUserMapper swUserMapper;
    @Override
    public SwUser queryByName(String userName) {
        return swUserMapper.findByUserName(userName);
    }

    /**
     * @param userName
     * @return
     */
    @Override
    public SwUser getByUserName(String userName) {
        return null;
    }
}
