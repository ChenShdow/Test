package com.edu.coupon.controller;

import com.edu.coupon.controller.validator.BindingResultUtil;
import com.edu.coupon.entity.CouponTemplate;
import com.edu.coupon.entity.param.CouponTemplateParam;
import com.edu.coupon.service.CouponTemplateService;
import com.edu.global.common.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("优惠券模板接口")
public class CouponTemplateController {
    @Autowired
    private CouponTemplateService couponTemplateService;

    @PostMapping("couponTemplate")
    @ApiOperation("优惠券添加模板")
    //springmvc接收参数 只能有一个@RequestBody  而且 RequestBody不能跟requestparam共用
    public ResultResponse resultResponse(
//            @ApiParam(value = "优惠券logo",name = "multipartFile",required = true)
            @ApiParam(value = "模板接收实体类") @Validated CouponTemplateParam couponTemplateParam,
            BindingResult bindingResult){
        BindingResultUtil.checkBindingResult(bindingResult);
        //todo 操作人员
        couponTemplateService.add(couponTemplateParam);
        return ResultResponse.success();
    }
}
