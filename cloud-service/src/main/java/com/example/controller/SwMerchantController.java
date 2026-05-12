package com.example.controller;

import com.example.entity.SwMerchant;
import com.example.returns.R;
import com.example.service.SwMerchantService;
import org.noggit.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
     * 查询所有商户
     */
    @GetMapping("/list")
    public R<List<SwMerchant>> findAll() {
        try {
            List<SwMerchant> list = StringUtils.isEmpty(swMerchantService.list()) ? new ArrayList<>() : swMerchantService.list();
            return R.ok(list);
        }catch(Exception e){
            return R.error("系统异常");
        }


    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public R<String> findOne(@PathVariable Long id) {
        try {
            Assert.notNull(id,"入参不能为空");
            SwMerchant merchant = swMerchantService.getById(id);
            Assert.notNull(merchant,"商户不存在");

            return R.ok(JSONUtil.toJSON(merchant));
        }catch(Exception e){
            return R.error("系统异常");
        }
    }




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


}