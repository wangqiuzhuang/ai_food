package com.example.controller;

import com.example.entity.SwFood;
import com.example.returns.R;
import com.example.service.SwFoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 食品商品表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Slf4j
@RestController
@RequestMapping("/swFood")
public class SwFoodController {

    @Autowired
    private SwFoodService swFoodService;

    /**
     * 商户ID查询下边全部食物
     */
    @GetMapping("findFoodByMerchantId/{id}")
    public R<List<SwFood>> findFoodByMerchantId(@PathVariable Long id,
                                                @RequestParam(required = false, defaultValue = "") String lang) {
        List<SwFood> list = swFoodService.findFoodByMerchantId(id);
        for (SwFood f : list) {
            f.applyLang(lang);
        }
        return R.ok(list);
    }

    /**
     * 食物ID查询食物详情
     */
    @GetMapping("findFoodByFoodId/{id}")
    public R<SwFood> findFoodByFoodId(@PathVariable Long id,
                                      @RequestParam(required = false, defaultValue = "") String lang) {
        SwFood food = swFoodService.findFoodByFoodId(id);
        if (food != null) {
            food.applyLang(lang);
        }
        return R.ok(food);
    }
}
