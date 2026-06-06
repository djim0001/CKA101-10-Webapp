package com.coupons.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.coupons.model.CouponService;
import com.coupons.model.CouponVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin/coupons/coupon.do")
public class CouponsServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			String str = req.getParameter("couponId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("couponId", "請輸入優惠券編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/admin/coupons/selectCoupon.jsp");
				failureView.forward(req, res);
				return;
			}
			
			Integer couponId = null;
			try {
				couponId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("couponId", "優惠券編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/admin/coupons/selectCoupon.jsp");
				failureView.forward(req, res);
				return;
			}
			
			CouponService couponSvc = new CouponService();
			CouponVO couponVO = couponSvc.getOneCoupon(couponId);
			if (couponVO == null) {
				errorMsgs.put("couponId", "查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/admin/coupons/selectCoupon.jsp");
				failureView.forward(req, res);
				return;
			}
			
			req.setAttribute("couponVO", couponVO);
			String url = "/admin/coupons/listOneCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if ("insert".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			String couponName = req.getParameter("couponName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (couponName == null || couponName.trim().length() == 0) {
				errorMsgs.put("couponName", "優惠券名稱: 請勿空白");
			} else if(!couponName.trim().matches(enameReg)) {
				errorMsgs.put("couponName", "優惠券名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			
			Integer discountDuration = null;
			try {
				discountDuration = Integer.valueOf(req.getParameter("discountDuration"));
			}catch(NumberFormatException e) {
				discountDuration = 0;
				errorMsgs.put("discountDuration", "優惠效期請填數字");
			}
			if (discountDuration <= 0) {
				errorMsgs.put("discountDuration", "優惠效期請填大於 0 的數字");
			}
			
			Integer triggerThreshold = null;
			try {
				if(req.getParameter("triggerThreshold").trim() == "") {
					triggerThreshold = 0;
				}else {
					triggerThreshold = Integer.valueOf(req.getParameter("triggerThreshold").trim());
				}
			}catch(NumberFormatException e) {
				triggerThreshold = 0;
				errorMsgs.put("triggerThreshold", "消費觸發門檻請填數字");
			}
			if (triggerThreshold < 0) {
				errorMsgs.put("triggerThreshold", "消費觸發門檻請填大於 0 的數字");
			}
			
			String bStr = req.getParameter("discount").trim();
			BigDecimal discount = null;
			if (bStr == null || bStr.trim().isEmpty()) {
				discount = BigDecimal.ZERO;
				errorMsgs.put("discount", "優惠券折扣請勿空白");
			} else {
				try {
					discount = new BigDecimal(bStr.trim());
					if (discount.compareTo(BigDecimal.ZERO) <= 0 || discount.compareTo(BigDecimal.ONE) > 0) {
						errorMsgs.put("discount", "優惠券折扣請填大於 0 且在 0~1 之間的數字");
					}
				} catch (NumberFormatException e) {
					discount = BigDecimal.ZERO;
					errorMsgs.put("discount", "優惠券折扣請填正確的數字格式");
				}
			}
			
			Integer discountLimit = null;
			try {
				if(req.getParameter("discountLimit").trim() == "") {
					discountLimit = 0;
				}else {
					discountLimit = Integer.valueOf(req.getParameter("discountLimit").trim());
				}
				} catch (NumberFormatException e) {
					discountLimit = 0;
					errorMsgs.put("discountLimit", "折扣上限請填數字");
				}
			if (discountLimit < 0) {
				errorMsgs.put("discountLimit", "折扣上限請填大於 0 的數字");
			}
			CouponVO couponVO = new CouponVO();
			couponVO.setCouponName(couponName);
			couponVO.setDiscount(discount);
			couponVO.setDiscountDuration(discountDuration);
			couponVO.setDiscountLimit(discountLimit);
			couponVO.setTriggerThreshold(triggerThreshold);
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponVO", couponVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/admin/coupons/addCoupon.jsp");
				failureView.forward(req, res);
				return;
			}
			
			CouponService couponSvc = new CouponService();
			couponVO = couponSvc.addCoupon(couponName, discountDuration, triggerThreshold, discount, discountLimit);
			
			RequestDispatcher successView = 
					req.getRequestDispatcher("/admin/coupons/listAllCoupon.jsp");
			successView.forward(req, res);
		}
		
		if ("getOne_For_Update".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			Integer couponId = Integer.valueOf(req.getParameter("couponId"));
			
			CouponService couponSvc = new CouponService();
			CouponVO couponVO = couponSvc.getOneCoupon(couponId);
							
			req.setAttribute("couponVO", couponVO); 
			RequestDispatcher successView = 
					req.getRequestDispatcher("/admin/coupons/updateCoupon.jsp");
			successView.forward(req, res);
		}
		
		if ("update".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			Integer couponId = Integer.valueOf(req.getParameter("couponId").trim());
			
			CouponService couponSvc = new CouponService();
			CouponVO couponVO = couponSvc.getOneCoupon(couponId);
			
			String couponName = req.getParameter("couponName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (couponName == null || couponName.trim().length() == 0) {
				errorMsgs.put("couponName", "優惠券名稱: 請勿空白");
			} else if(!couponName.trim().matches(enameReg)) {
				errorMsgs.put("couponName", "優惠券名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponVO", couponVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/admin/coupons/updateCoupon.jsp");
				failureView.forward(req, res);
				return;
			}
			couponVO = couponSvc.updateCoupon(
					couponName, couponVO.getDiscountDuration(), couponVO.getTriggerThreshold()
					,couponVO.getDiscount(), couponVO.getDiscountLimit(), couponId);
			req.setAttribute("couponVO", couponVO);
			RequestDispatcher successView = 
					req.getRequestDispatcher("/admin/coupons/listAllCoupon.jsp"); 
			successView.forward(req, res);
		}
		
		if ("delete".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			Integer couponId = Integer.valueOf(req.getParameter("couponId"));
			
			CouponService couponSvc = new CouponService();
			couponSvc.deleteCoupon(couponId);
			
			RequestDispatcher successView = 
					req.getRequestDispatcher("/admin/coupons/listAllCoupon.jsp");// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
		
	}
	
}
