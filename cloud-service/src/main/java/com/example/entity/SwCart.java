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
 * 购物车表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Getter
@Setter
@TableName("sw_cart")
public class SwCart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车ID
     */
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Long cartId;

    /**
     * 关联用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 关联商户ID
     */
    @TableField("merchant_id")
    private Long merchantId;

    /**
     * 关联食品商品ID
     */
    @TableField("food_id")
    private Long foodId;

    /**
     * 购买数量
     */
    @TableField("food_num")
    private Integer foodNum;

    /**
     * 加入购物车时单价
     */
    @TableField("food_price")
    private BigDecimal foodPrice;

    /**
     * 商品图片URL
     */
    @TableField("food_img")
    private String foodImg;

    /**
     * 商品名称
     */
    @TableField("food_name")
    private String foodName;

    /**
     * 是否选中 1选中 0未选中
     */
    @TableField("selected")
    private Byte selected;

    /**
     * 乐观锁版本号
     */
    @TableField("jpa_version")
    private Long jpaVersion;

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
}
