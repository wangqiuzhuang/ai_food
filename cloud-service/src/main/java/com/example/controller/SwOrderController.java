package com.example.controller;

import com.example.returns.R;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.SwOrderService;
import com.example.entity.SwOrder;
import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@RestController
@RequestMapping("/swOrder")
public class SwOrderController {

    @Autowired
    private SwOrderService swOrderService;

    /**
     * 提交订单
     */
    @PostMapping("/save")
    public R<String> save(@RequestBody SwOrder entity) {
        Assert.notNull(entity,"入参不能为空");
        swOrderService.save(entity);
        return R.ok("提交成功");
    }

    /**
     * 删除订单
     */
    @GetMapping("/delete/{id}")
    public R<String> delete(@PathVariable Long id) {
        swOrderService.removeById(id);
        return R.ok("删除成功");
    }

    /**
     * 查询客户下所有订单
     */
    @GetMapping("/findByUserId/{userId}")
    public R<List<SwOrder>> findByUserId(@PathVariable Long userId) {
        return R.ok(swOrderService.findByUserId(userId));
    }

}