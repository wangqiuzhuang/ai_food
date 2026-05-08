package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-08
 */
@Getter
@Setter
@TableName("sw_user")
public class SwUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID（主键）
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码（BCrypt加密）
     */
    @TableField("password")
    private String password;

    /**
     * 头像图片URL
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 乐观锁版本号
     */
    @TableField("jpa_version")
    private Long jpaVersion;
}
