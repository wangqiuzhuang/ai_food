package com.example.controller;

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
     * 新增或修改
     */
    @PostMapping("/save")
    public String save(@RequestBody SwOrder entity) {
        swOrderService.saveOrUpdate(entity);
        return "操作成功";
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        swOrderService.removeById(id);
        return "删除成功";
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public List<SwOrder> findAll() {
        return swOrderService.list();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public SwOrder findOne(@PathVariable Long id) {
        return swOrderService.getById(id);
    }
}