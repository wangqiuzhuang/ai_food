package com.example.controller;

import com.example.entity.SwMerchant;
import com.example.returns.R;
import com.example.service.SwMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
     * 查询所有商户  首页
     */
    @GetMapping("/list")
    public R<List<SwMerchant>> findByClass(@RequestParam Integer merchantClass) {
        List<SwMerchant> list = new ArrayList<>();
        try {
            if(Objects.nonNull(merchantClass)){
                list = swMerchantService.findByClass(merchantClass);
            }else{
                list = StringUtils.isEmpty(swMerchantService.list()) ? new ArrayList<>() : swMerchantService.list();
            }
            return R.ok(list);
        }catch(Exception e){
            return R.error("系统异常");
        }


    }


    /**
     * 根据name查询
     */
    @GetMapping("/merchantName")
    public R<List<SwMerchant>> getMerchantByName(@RequestParam String merchantName) {
        try {
            Assert.notNull(merchantName,"入参不能为空");
            List<SwMerchant> merchant = swMerchantService.getMerchantByName(merchantName);
            return R.ok(merchant);
        }catch(Exception e){
            return R.error("系统异常");
        }
    }




//    /**
//     * 新增或修改
//     */
//    @PostMapping("/save")
//    public String save(@RequestBody SwMerchant entity) {
//        swMerchantService.saveOrUpdate(entity);
//        return "操作成功";
//    }
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        swMerchantService.removeById(id);
//        return "删除成功";
//    }
//

}