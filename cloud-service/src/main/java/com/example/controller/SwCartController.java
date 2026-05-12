package com.example.controller;

import com.example.entity.SwCart;
import com.example.returns.R;
import com.example.service.SwCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@RestController
@RequestMapping("/swCart")
public class SwCartController {

    @Autowired
    private SwCartService swCartService;

    /**
     * 加车
     */
    @PostMapping("/addCart")
    public R<String> save(@RequestBody SwCart entity) {
        Assert.notNull(entity,"入参不能为空");
        swCartService.save(entity);
        return R.ok("加购物车成功");
    }

        /**
     * 根据用户ID查询
     */
    @GetMapping("/{userId}")
    public R<List<SwCart>> findOne(@PathVariable Long userId) {
        return R.ok(swCartService.findByUserId(userId));
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable Long id) {
        try {
            Assert.notNull(id,"入参不能为空");
            swCartService.removeById(id);
            return R.ok("删除成功");
        }catch(Exception e){
            return R.ok("系统异常");
        }
    }
}