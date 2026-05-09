package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.SwUserAddressService;
import com.example.entity.SwUserAddress;
import java.util.List;

/**
 * <p>
 * 用户收货地址表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@RestController
@RequestMapping("/swUserAddress")
public class SwUserAddressController {

    @Autowired
    private SwUserAddressService swUserAddressService;

    /**
     * 新增或修改
     */
    @PostMapping("/save")
    public String save(@RequestBody SwUserAddress entity) {
        swUserAddressService.saveOrUpdate(entity);
        return "操作成功";
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        swUserAddressService.removeById(id);
        return "删除成功";
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public List<SwUserAddress> findAll() {
        return swUserAddressService.list();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public SwUserAddress findOne(@PathVariable Long id) {
        return swUserAddressService.getById(id);
    }
}