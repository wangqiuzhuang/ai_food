package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-08
 */
@Getter
@Setter
@TableName("sw_order")
public class SwOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 商户ID
     */
    @TableField("merchant_id")
    private Long merchantId;

    /**
     * 收货地址ID
     */
    @TableField("address_id")
    private Long addressId;

    /**
     * 总金额
     */
    @TableField("total_price")
    private BigDecimal totalPrice;

    /**
     * 0待付款 1已付款 2已接单 3配送中 4完成 5取消
     */
    @TableField("order_status")
    private Byte orderStatus;

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
