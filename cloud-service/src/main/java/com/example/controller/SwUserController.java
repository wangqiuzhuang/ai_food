package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.SwUserService;
import com.example.entity.SwUser;
import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@RestController
@RequestMapping("/swUser")
public class SwUserController {

    @Autowired
    private SwUserService swUserService;

    /**
     * 新增或修改
     */
    @PostMapping("/save")
    public String save(@RequestBody SwUser entity) {
        swUserService.saveOrUpdate(entity);
        return "操作成功";
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        swUserService.removeById(id);
        return "删除成功";
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public List<SwUser> findAll() {
        return swUserService.list();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public SwUser findOne(@PathVariable Long id) {
        return swUserService.getById(id);
    }
}