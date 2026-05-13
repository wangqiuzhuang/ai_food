package com.example.service;

import com.example.entity.SwUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
public interface SwUserService extends IService<SwUser> {

    SwUser queryByName(String userName);

    SwUser getByUserName(String userName);
}
