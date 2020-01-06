package com.edu.coupon.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("接收优惠券的模板参数")
public class CouponTemplateParam implements Serializable {
    @ApiModelProperty(name = "cCategory",value = "优惠券类型：0-立减 1-满减 2-折扣",dataType = "string",required = true,example = "2")
    @NotBlank(message = "分类不能为null")
    private String cCategory;

    @ApiModelProperty(name = "cExpireType",value = "过期类型：0-固定时间 1-动态时间",dataType = "string",required = true,example = "0")
    @NotBlank(message = "过期类型不能为空")
    private String cExpireType;

    @ApiModelProperty(name = "cExpireDay",value = "过期天数",dataType = "integer",required = true,example = "10")
    @NotNull(message = "过期天数不能为空")
    private Integer cExpireDay;

    @ApiModelProperty(name = "cMerchantId",value = "商家id： null为平台发送",dataType = "string",example = "123456789")
    private String cMerchantId;

    @ApiModelProperty(name = "cMerchantName",value = "商家名称： null为平台发送",dataType = "string",example = "帝霸")
    private String cMerchantName;

    @ApiModelProperty(name = "cDesc",value = "详细描述：优惠券的描述",dataType = "string",required = true,example = "XXXX")
    @NotBlank(message = "描述不能为空")
    private String cDesc;

    @ApiModelProperty(name = "cProductLine",value = "生产线",dataType = "string",required = true,example = "ccc")
    @NotBlank(message = "生产线不能为空")
    private String cProductLine;

    @ApiModelProperty(name = "cLimiter",value = "每个人最多领的数量",dataType = "integer",required = true,example = "5")
    @NotNull(message = "数量限制不能为空")
    private Integer cLimiter;

    @ApiModelProperty(name = "cCount",value = "优惠券的数量",dataType = "integer",required = true,example = "100")
    @NotNull(message = "优惠券数量不能为空")
    private Integer cCount;

    @ApiModelProperty(name = "cAmount",value = "折扣 金额  金额0<amount<1就是折扣",dataType = "double",required = true,example = "200")
    @NotNull(message = "不能为空")
    private double cAmount;

    @ApiModelProperty(name = "cAmountLimit",value = "金额限制",dataType = "double",required = true,example = "300")
    @NotNull(message = "金额不能为空")
    private double cAmountLimit;

    @ApiModelProperty(name = "cLinkUrl",value = "店铺的链接",dataType = "string",required = true)
    @NotBlank(message = "店铺链接不能为空")
    private String cLinkUrl;

    @ApiModelProperty(name = "cConsumeStatus",value = "消费状态",dataType = "string",required = true,example = "0")
    @NotBlank(message = "消费状态不能为空")
    private String cConsumeStatus;

    public void setcConsumeStatus(String cConsumeStatus) {
        this.cConsumeStatus = cConsumeStatus;
    }

    public String getcConsumeStatus() {
        return cConsumeStatus;
    }

    public String getcCategory() {
        return cCategory;
    }

    public String getcExpireType() {
        return cExpireType;
    }

    public Integer getcExpireDay() {
        return cExpireDay;
    }

    public String getcMerchantId() {
        return cMerchantId;
    }

    public String getcMerchantName() {
        return cMerchantName;
    }

    public String getcDesc() {
        return cDesc;
    }

    public String getcProductLine() {
        return cProductLine;
    }

    public Integer getcLimiter() {
        return cLimiter;
    }

    public Integer getcCount() {
        return cCount;
    }

    public double getcAmount() {
        return cAmount;
    }

    public double getcAmountLimit() {
        return cAmountLimit;
    }

    public String getcLinkUrl() {
        return cLinkUrl;
    }

    public void setcCategory(String cCategory) {
        this.cCategory = cCategory;
    }

    public void setcExpireType(String cExpireType) {
        this.cExpireType = cExpireType;
    }

    public void setcExpireDay(Integer cExpireDay) {
        this.cExpireDay = cExpireDay;
    }

    public void setcMerchantId(String cMerchantId) {
        this.cMerchantId = cMerchantId;
    }

    public void setcMerchantName(String cMerchantName) {
        this.cMerchantName = cMerchantName;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public void setcProductLine(String cProductLine) {
        this.cProductLine = cProductLine;
    }

    public void setcLimiter(Integer cLimiter) {
        this.cLimiter = cLimiter;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }

    public void setcAmount(double cAmount) {
        this.cAmount = cAmount;
    }

    public void setcAmountLimit(double cAmountLimit) {
        this.cAmountLimit = cAmountLimit;
    }

    public void setcLinkUrl(String cLinkUrl) {
        this.cLinkUrl = cLinkUrl;
    }
}
