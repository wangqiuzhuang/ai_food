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

    @TableId(value = "merchant_id", type = IdType.AUTO)
    private Long merchantId;

    @TableField("merchant_name")
    private String merchantName;

    @TableField("merchant_name_ko")
    private String merchantNameKo;

    @TableField("merchant_name_cn")
    private String merchantNameCn;

    @TableField("phone")
    private String phone;

    @TableField("address")
    private String address;

    @TableField("address_ko")
    private String addressKo;

    @TableField("address_cn")
    private String addressCn;

    @TableField("status")
    private Byte status;

    @TableField("merchant_img")
    private String merchantImg;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("jpa_version")
    private Long jpaVersion;

    @TableField("merchant_class")
    private  int merchantClass;

    /**
     * 根据语言填充对应文本到 merchantName/address
     */
    public void applyLang(String lang) {
        if ("ko".equals(lang) && merchantNameKo != null) {
            this.merchantName = merchantNameKo;
        } else if ("cn".equals(lang) && merchantNameCn != null) {
            this.merchantName = merchantNameCn;
        }
        if ("ko".equals(lang) && addressKo != null) {
            this.address = addressKo;
        } else if ("cn".equals(lang) && addressCn != null) {
            this.address = addressCn;
        }
    }
}
