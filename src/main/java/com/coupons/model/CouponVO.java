package com.coupons.model;

public class CouponVO {

	private Integer couponId;
	private String couponName;
	private Integer discountDuration;
	private Integer triggerThreshold;
	private Double discount;
	private Integer discountLimit;

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Integer getDiscountDuration() {
		return discountDuration;
	}

	public void setDiscountDuration(Integer discountDuration) {
		this.discountDuration = discountDuration;
	}

	public Integer getTriggerThreshold() {
		return triggerThreshold;
	}

	public void setTriggerThreshold(Integer triggerThreshold) {
		this.triggerThreshold = triggerThreshold;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getDiscountLimit() {
		return discountLimit;
	}

	public void setDiscountLimit(Integer discountLimit) {
		this.discountLimit = discountLimit;
	}

}
