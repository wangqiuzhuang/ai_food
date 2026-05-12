package com.example.controller;

import com.example.returns.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.SwOrderItemService;
import com.example.entity.SwOrderItem;
import java.util.List;

/**
 * <p>
 * 订单明细表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@RestController
@RequestMapping("/swOrderItem")
public class SwOrderItemController {

    @Autowired
    private SwOrderItemService swOrderItemService;

    /**
     * 根据订单id查询订单详情
     */
    @GetMapping("/findOrderItemByOrderId/{orderNo}")
    public R<List<SwOrderItem>> findOrderItemByOrderId(@PathVariable String orderNo) {
        return R.ok(swOrderItemService.findOrderItemByOrderId(orderNo));
    }

}