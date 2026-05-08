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
 * 食品商品表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-08
 */
@Getter
@Setter
@TableName("sw_food")
public class SwFood implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品主键ID
     */
    @TableId(value = "food_id", type = IdType.AUTO)
    private Long foodId;

    /**
     * 关联商户ID
     */
    @TableField("merchant_id")
    private Long merchantId;

    /**
     * 食品名称
     */
    @TableField("food_name")
    private String foodName;

    /**
     * 售价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 库存数量
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 状态 1上架 0下架
     */
    @TableField("status")
    private Byte status;

    /**
     * 食品商品图片URL
     */
    @TableField("food_img")
    private String foodImg;

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
