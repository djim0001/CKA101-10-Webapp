package com.coupons.model;

import java.util.List;


public interface CouponDAO_interface {
	public void insert(CouponVO couponsVO);
    public void update(CouponVO couponsVO);
    public void delete(Integer couponId);
    public CouponVO findByPrimaryKey(Integer couponId);
    public List<CouponVO> getAll();
}
