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
 * 评价表
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-12
 */
@Getter
@Setter
@TableName("sw_comments")
public class SwComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    @TableField("food_id")
    private String foodId;

    @TableField("user_id")
    private Long userId;

    @TableField("merchant_id")
    private Long merchantId;

    @TableField("comment_msg")
    private String commentMsg;

    @TableField("comment_msg_ko")
    private String commentMsgKo;

    @TableField("comment_msg_cn")
    private String commentMsgCn;

    @TableField("start")
    private BigDecimal start;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("jpa_version")
    private Long jpaVersion;

    /**
     * 根据语言填充对应文本到 commentMsg
     */
    public void applyLang(String lang) {
        if ("ko".equals(lang) && commentMsgKo != null) {
            this.commentMsg = commentMsgKo;
        } else if ("cn".equals(lang) && commentMsgCn != null) {
            this.commentMsg = commentMsgCn;
        }
    }
}
