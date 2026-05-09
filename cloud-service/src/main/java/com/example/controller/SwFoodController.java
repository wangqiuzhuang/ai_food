package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.SwFoodService;
import com.example.entity.SwFood;
import java.util.List;

/**
 * <p>
 * 食品商品表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@RestController
@RequestMapping("/swFood")
public class SwFoodController {

    @Autowired
    private SwFoodService swFoodService;

    /**
     * 新增或修改
     */
    @PostMapping("/save")
    public String save(@RequestBody SwFood entity) {
        swFoodService.saveOrUpdate(entity);
        return "操作成功";
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        swFoodService.removeById(id);
        return "删除成功";
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public List<SwFood> findAll() {
        return swFoodService.list();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public SwFood findOne(@PathVariable Long id) {
        return swFoodService.getById(id);
    }
}