package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.SwMerchantService;
import com.example.entity.SwMerchant;
import java.util.List;

/**
 * <p>
 * 商户表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@RestController
@RequestMapping("/swMerchant")
public class SwMerchantController {

    @Autowired
    private SwMerchantService swMerchantService;

    /**
     * 新增或修改
     */
    @PostMapping("/save")
    public String save(@RequestBody SwMerchant entity) {
        swMerchantService.saveOrUpdate(entity);
        return "操作成功";
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        swMerchantService.removeById(id);
        return "删除成功";
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public List<SwMerchant> findAll() {
        return swMerchantService.list();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public SwMerchant findOne(@PathVariable Long id) {
        return swMerchantService.getById(id);
    }
}