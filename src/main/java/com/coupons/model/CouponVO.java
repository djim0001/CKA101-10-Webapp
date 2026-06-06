package com.coupons.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coupons")
public class CouponVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupon_id")
	private Integer couponId;
	@Column(name = "coupon_name")
	private String couponName;
	@Column(name = "discount_duration")
	private Integer discountDuration;
	@Column(name = "trigger_threshold")
	private Integer triggerThreshold;
	@Column(name = "discount")
	private BigDecimal discount;
	@Column(name = "discount_limit")
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

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Integer getDiscountLimit() {
		return discountLimit;
	}

	public void setDiscountLimit(Integer discountLimit) {
		this.discountLimit = discountLimit;
	}

}
