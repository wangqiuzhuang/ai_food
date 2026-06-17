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
 * @since 2026-05-09
 */
@Getter
@Setter
@TableName("sw_food")
public class SwFood implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "food_id", type = IdType.AUTO)
    private Long foodId;

    @TableField("merchant_id")
    private Long merchantId;

    @TableField("food_name")
    private String foodName;

    @TableField("food_name_ko")
    private String foodNameKo;

    @TableField("food_name_cn")
    private String foodNameCn;

    @TableField("price")
    private BigDecimal price;

    @TableField("stock")
    private Integer stock;

    @TableField("status")
    private Byte status;

    @TableField("food_img")
    private String foodImg;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("jpa_version")
    private Long jpaVersion;

    @TableField("food_desc")
    private String foodDesc;

    @TableField("food_desc_ko")
    private String foodDescKo;

    @TableField("food_desc_cn")
    private String foodDescCn;

    /**
     * 根据语言填充对应文本到 foodName/foodDesc
     */
    public void applyLang(String lang) {
        if ("ko".equals(lang) && foodNameKo != null) {
            this.foodName = foodNameKo;
        } else if ("cn".equals(lang) && foodNameCn != null) {
            this.foodName = foodNameCn;
        }
        if ("ko".equals(lang) && foodDescKo != null) {
            this.foodDesc = foodDescKo;
        } else if ("cn".equals(lang) && foodDescCn != null) {
            this.foodDesc = foodDescCn;
        }
    }
}
