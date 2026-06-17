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
    public R<List<SwMerchant>> findByClass(@RequestParam Integer merchantClass,
                                           @RequestParam(required = false, defaultValue = "") String lang) {
        List<SwMerchant> list = new ArrayList<>();
        try {
            if(Objects.nonNull(merchantClass)){
                list = swMerchantService.findByClass(merchantClass);
            }else{
                list = StringUtils.isEmpty(swMerchantService.list()) ? new ArrayList<>() : swMerchantService.list();
            }
            for (SwMerchant m : list) {
                m.applyLang(lang);
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
    public R<List<SwMerchant>> getMerchantByName(@RequestParam String merchantName,
                                                 @RequestParam(required = false, defaultValue = "") String lang) {
        try {
            Assert.notNull(merchantName,"入参不能为空");
            List<SwMerchant> merchant = swMerchantService.getMerchantByName(merchantName);
            for (SwMerchant m : merchant) {
                m.applyLang(lang);
            }
            return R.ok(merchant);
        }catch(Exception e){
            return R.error("系统异常");
        }
    }
}
