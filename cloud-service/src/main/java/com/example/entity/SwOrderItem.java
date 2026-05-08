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
 * 订单明细表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-08
 */
@Getter
@Setter
@TableName("sw_order_item")
public class SwOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;

    @TableField("order_no")
    private String orderNo;

    @TableField("food_id")
    private Long foodId;

    @TableField("food_name")
    private String foodName;

    @TableField("food_img")
    private String foodImg;

    @TableField("food_price")
    private BigDecimal foodPrice;

    @TableField("food_num")
    private Integer foodNum;

    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 乐观锁版本号
     */
    @TableField("jpa_version")
    private Long jpaVersion;
}
