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
 * 用户收货地址表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Getter
@Setter
@TableName("sw_user_address")
public class SwUserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "address_id", type = IdType.AUTO)
    private Long addressId;

    @TableField("user_id")
    private Long userId;

    /**
     * 收货人
     */
    @TableField("receiver_name")
    private String receiverName;

    /**
     * 电话
     */
    @TableField("receiver_phone")
    private String receiverPhone;

    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("district")
    private String district;

    /**
     * 详细地址
     */
    @TableField("detail_address")
    private String detailAddress;

    @TableField("is_default")
    private Byte isDefault;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 乐观锁版本号
     */
    @TableField("jpa_version")
    private Long jpaVersion;
}
