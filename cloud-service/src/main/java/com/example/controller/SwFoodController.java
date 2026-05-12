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
     * @param id
     * @return
     */
    @GetMapping("findFoodByMerchantId/{id}")
    public R<List<SwFood>> findFoodByMerchantId(@PathVariable Long id) {
        return R.ok(swFoodService.findFoodByMerchantId(id));
    }

    /**
     * 食物ID查询食物详情
     * @param id
     * @return
     */
    @GetMapping("findFoodByFoodId/{id}")
    public R<SwFood> findFoodByFoodId(@PathVariable Long id) {
        return R.ok(swFoodService.findFoodByFoodId(id));
    }

//
//
//    /**
//     * 新增或修改
//     */
//    @PostMapping("/save")
//    public String save(@RequestBody SwFood entity) {
//        swFoodService.saveOrUpdate(entity);
//        return "操作成功";
//    }
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        swFoodService.removeById(id);
//        return "删除成功";
//    }
//
//    /**
//     * 查询所有
//     */
//    @GetMapping("/list")
//    public List<SwFood> findAll() {
//        return swFoodService.list();
//    }
//

}