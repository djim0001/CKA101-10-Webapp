package com.coupons.model;

import java.math.BigDecimal;
import java.util.List;

public class CouponService {
	private CouponDAO_interface dao;
	
	public CouponService() {
//		dao = new CouponJDBCDAO();
		dao = new CouponHibernateDAO();
	}
	
	public CouponVO addCoupon(
			String coupon_name,Integer discount_duration,Integer trigger_threshold,
			BigDecimal discount,Integer discount_limit) {
		CouponVO couponVO = new CouponVO();
		couponVO.setCouponName(coupon_name);
		couponVO.setDiscountDuration(discount_duration);
		couponVO.setTriggerThreshold(trigger_threshold);
		couponVO.setDiscount(discount);
		couponVO.setDiscountLimit(discount_limit);
		dao.insert(couponVO);

		return couponVO;
	}

	public CouponVO updateCoupon(String coupon_name, Integer discount_duration, Integer trigger_threshold, 
			BigDecimal discount,Integer discount_limit, Integer coupon_id) {

		CouponVO couponVO = new CouponVO();
		couponVO.setCouponId(coupon_id);
		couponVO.setCouponName(coupon_name);
		couponVO.setDiscountDuration(discount_duration);
		couponVO.setTriggerThreshold(trigger_threshold);
		couponVO.setDiscount(discount);
		couponVO.setDiscountLimit(discount_limit);
		dao.update(couponVO);

		return couponVO;
	}
	public void deleteCoupon(Integer coupon_id) {
		dao.delete(coupon_id);
	}

	public CouponVO getOneCoupon(Integer coupon_id) {
		return dao.findByPrimaryKey(coupon_id);
	}

	public List<CouponVO> getAll() {
		return dao.getAll();
	}
	
	
	
}
