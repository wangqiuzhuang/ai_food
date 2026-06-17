package com.example.controller;

import com.example.returns.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.SwCommentsService;
import com.example.entity.SwComments;
import java.util.List;

/**
 * <p>
 * 评价表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-12
 */
@RestController
@RequestMapping("/swComments")
public class SwCommentsController {

    @Autowired
    private SwCommentsService swCommentsService;

    /**
     * 新增评价
     */
    @PostMapping("/save")
    public R<String> save(@RequestBody SwComments entity) {
        swCommentsService.save(entity);
        return R.ok("评价成功");
    }

    /**
     * 删除评价
     */
    @GetMapping("/delete/{id}")
    public R<String> delete(@PathVariable Long id) {
        swCommentsService.removeById(id);
        return R.ok("评价删除成功");
    }

    /**
     * 查询指定用户发表的全部评价
     */
    @GetMapping("/queryCommentsByUserId/{userId}")
    public R<List<SwComments>> queryCommentsByUserId(@PathVariable Long userId,
                                                     @RequestParam(required = false, defaultValue = "") String lang) {
        List<SwComments> list = swCommentsService.queryCommentsByUserId(userId);
        for (SwComments c : list) {
            c.applyLang(lang);
        }
        return R.ok(list);
    }

    /**
     * 查询指定商户下指定商品的的全部评价
     */
    @GetMapping("/queryCommentsByFoodIdAndMerchantId/{foodId}/{merchantId}")
    public R<List<SwComments>> queryCommentsByFoodIdAndMerchantId(@PathVariable Long foodId,
                                                                  @PathVariable Long merchantId,
                                                                  @RequestParam(required = false, defaultValue = "") String lang) {
        List<SwComments> list = swCommentsService.queryCommentsByFoodIdAndMerchantId(foodId, merchantId);
        for (SwComments c : list) {
            c.applyLang(lang);
        }
        return R.ok(list);
    }
}
