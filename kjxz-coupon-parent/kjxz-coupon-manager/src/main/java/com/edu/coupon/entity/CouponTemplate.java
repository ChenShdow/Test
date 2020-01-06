package com.edu.coupon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponTemplate implements Serializable {
    private Integer id;

    private String cId;

    private String cCategory;

    private String cExpireType;

    private Integer cExpireDay;

    private Date cCreateTime;

    private String cConsumeStatus;

    private String cMerchantId;

    private String cMerchantName;

    private String cLogo;

    private String cDesc;

    private String cProductLine;

    private String cAreaId;

    private Integer cLimiter;

    private Integer cCount;

    private BigDecimal cAmount;

    private BigDecimal cAmountLimit;

    private String cLinkUrl;

}