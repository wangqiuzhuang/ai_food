package com.example.controller;

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
     * 新增或修改
     */
    @PostMapping("/save")
    public String save(@RequestBody SwOrderItem entity) {
        swOrderItemService.saveOrUpdate(entity);
        return "操作成功";
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        swOrderItemService.removeById(id);
        return "删除成功";
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public List<SwOrderItem> findAll() {
        return swOrderItemService.list();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public SwOrderItem findOne(@PathVariable Long id) {
        return swOrderItemService.getById(id);
    }
}