package com.edu.coupon.dao;

import com.edu.coupon.entity.CouponTemplate;

public interface CouponTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CouponTemplate record);

    int insertSelective(CouponTemplate record);

    CouponTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CouponTemplate record);

    int updateByPrimaryKey(CouponTemplate record);
}