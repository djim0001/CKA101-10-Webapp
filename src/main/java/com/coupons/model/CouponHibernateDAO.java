package com.coupons.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class CouponHibernateDAO implements CouponDAO_interface{
	private SessionFactory factory;
	public CouponHibernateDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public void insert(CouponVO couponVO) {
		getSession().persist(couponVO);		
	}

	@Override
	public void update(CouponVO couponVO) {
		getSession().merge(couponVO);
		
	}

	@Override
	public void delete(Integer couponId) {
		CouponVO coupon = getSession().get(CouponVO.class, couponId);
		if (coupon != null) {
			getSession().remove(coupon);
		}		
	}

	@Override
	public CouponVO findByPrimaryKey(Integer couponId) {
		return getSession().get(CouponVO.class, couponId);
	}

	@Override
	public List<CouponVO> getAll() {
		return getSession().createQuery("from CouponVO", CouponVO.class).getResultList();
	}
}
