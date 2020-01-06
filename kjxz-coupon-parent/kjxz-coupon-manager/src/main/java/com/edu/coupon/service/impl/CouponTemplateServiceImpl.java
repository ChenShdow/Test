package com.edu.coupon.service.impl;

import com.edu.coupon.dao.CouponTemplateMapper;
import com.edu.coupon.entity.CouponTemplate;
import com.edu.coupon.entity.param.CouponTemplateParam;
import com.edu.coupon.service.CouponTemplateService;
import com.edu.coupon.util.CouponCodeUtil;
import com.edu.coupon.util.FutureUtils;
import com.edu.coupon.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {
    @Autowired
    private CouponTemplateMapper couponTemplateMapper;
    @Autowired
    private IdUtils idUtils;
    @Autowired
    private CouponCodeUtil couponCodeUtil;

    @Override
    @Transactional
    public void add(CouponTemplateParam couponTemplateParam) {
        CouponTemplate build = CouponTemplate.builder().cAmount(new BigDecimal(String.valueOf(couponTemplateParam.getcAmount())))
                .cAreaId(couponTemplateParam.getcMerchantId())
                .cAmountLimit(new BigDecimal(String.valueOf(couponTemplateParam.getcAmountLimit())))
                .cCategory(couponTemplateParam.getcCategory())
                .cConsumeStatus(couponTemplateParam.getcConsumeStatus())
                .cCount(couponTemplateParam.getcCount())
                .cDesc(couponTemplateParam.getcDesc())
                .cExpireDay(couponTemplateParam.getcExpireDay())
                .cExpireType(couponTemplateParam.getcExpireType())
                .cLimiter(couponTemplateParam.getcLimiter())
                //暂时
                .cLinkUrl(couponTemplateParam.getcMerchantId())
                .cMerchantId(couponTemplateParam.getcMerchantId())
                .cMerchantName(couponTemplateParam.getcMerchantName())
                .cProductLine(couponTemplateParam.getcProductLine())
                .build();

        //todo logo linkUrl
        //todo redis

        //生成id
        build.setCId(FutureUtils.get(idUtils.getId(couponTemplateParam.getcMerchantId())));
        //生成优惠券码
        List<String> list = couponCodeUtil.generateCode(couponTemplateParam.getcCount(), couponTemplateParam.getcMerchantId());

        //todo 调用c_coupon_code_user
        couponTemplateMapper.insertSelective(build);
    }
}
