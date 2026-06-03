package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商户表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Getter
@Setter
@TableName("sw_merchant")
public class SwMerchant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户主键ID
     */
    @TableId(value = "merchant_id", type = IdType.AUTO)
    private Long merchantId;

    /**
     * 商户名称
     */
    @TableField("merchant_name")
    private String merchantName;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 商户地址
     */
    @TableField("address")
    private String address;

    /**
     * 状态 1正常 0停业
     */
    @TableField("status")
    private Byte status;

    /**
     * 商户封面图片URL
     */
    @TableField("merchant_img")
    private String merchantImg;

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

    @TableField("merchant_class")
    private  int merchantClass;

}
