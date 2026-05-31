package com.coupons.controller;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.coupons.model.*;


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
		
if ("getOne_For_Display".equals(action)) { // 來自select的請求

//			List<String> errorMsgs = new LinkedList<String>();
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("couponId");
				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入優惠券編號");
					errorMsgs.put("couponId", "請輸入優惠券編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/admin/coupons/selectCoupon.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer couponId = null;
				try {
					couponId = Integer.valueOf(str);
				} catch (Exception e) {
//					errorMsgs.add("優惠券編號格式不正確");
					errorMsgs.put("couponId", "優惠券編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/admin/coupons/selectCoupon.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				CouponService couponSvc = new CouponService();
				CouponVO couponVO = couponSvc.getOneCoupon(couponId);
				if (couponVO == null) {
//					errorMsgs.add("查無資料");
					errorMsgs.put("couponId", "查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/admin/coupons/selectCoupon.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("couponVO", couponVO); // 資料庫取出的empVO物件,存入req
				String url = "/admin/coupons/listOneCoupon.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
}
		
if ("insert".equals(action)) { // 來自add的請求  
//			List<String> errorMsgs = new LinkedList<String>();
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			String couponName = req.getParameter("couponName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (couponName == null || couponName.trim().length() == 0) {
				errorMsgs.put("couponName", "優惠券名稱: 請勿空白");
			} else if(!couponName.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("couponName", "優惠券名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			
			Integer discountDuration = null;
			try {
				discountDuration = Integer.valueOf(req.getParameter("discountDuration"));
			}catch(NumberFormatException e) {
				discountDuration = 0;
				errorMsgs.put("discountDuration", "優惠效期請填數字");
			}
			if (discountDuration < 0) {
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
			if (discountDuration < 0) {
				errorMsgs.put("triggerThreshold", "消費觸發門檻請填大於 0 的數字");
			}
			
			Double discount = null;
			try {
				discount = Double.valueOf(req.getParameter("discount").trim());
				} catch (NumberFormatException e) {
					discount = 0.0;
					errorMsgs.put("discount", "優惠券折扣請填數字");
				}
			if (discount <= 0 || discount > 1) {
				errorMsgs.put("discount", "優惠券折扣請填大於 0 且在 0~1 之間的數字");
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
				errorMsgs.put("discount", "折扣上限請填大於 0 的數字");
			}
			CouponVO couponVO = new CouponVO();
			couponVO.setCouponName(couponName);
			couponVO.setDiscount(discount);
			couponVO.setDiscountDuration(discountDuration);
			couponVO.setDiscountLimit(discountLimit);
			couponVO.setTriggerThreshold(triggerThreshold);
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponVO", couponVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/admin/coupons/addCoupon.jsp");
				failureView.forward(req, res);
				return;
			}
			CouponService couponSvc = new CouponService();
			couponVO = couponSvc.addCoupon(couponName, discountDuration, triggerThreshold, discount, discountLimit);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/admin/coupons/listAllCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
}
		
if ("getOne_For_Update".equals(action)) { // 來自listAll的請求

			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數****************************************/
			Integer couponId = Integer.valueOf(req.getParameter("couponId"));
			
			/***************************2.開始查詢資料****************************************/
			CouponService couponSvc = new CouponService();
			CouponVO couponVO = couponSvc.getOneCoupon(couponId);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("couponVO", couponVO);         // 資料庫取出的empVO物件,存入req
			String url = "/admin/coupons/updateCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
}

if ("update".equals(action)) { // 來自update.jsp的請求
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			Integer couponId = Integer.valueOf(req.getParameter("couponId").trim());
			String couponName = req.getParameter("couponName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (couponName == null || couponName.trim().length() == 0) {
				errorMsgs.put("couponName", "優惠券名稱: 請勿空白");
			} else if(!couponName.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("couponName", "優惠券名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			
			Integer discountDuration = Integer.valueOf(req.getParameter("discountDuration").trim());
			Integer triggerThreshold = Integer.valueOf(req.getParameter("triggerThreshold").trim());
			Double discount = Double.valueOf(req.getParameter("discount").trim());
			Integer discountLimit = Integer.valueOf(req.getParameter("discountLimit").trim());
			
			CouponVO couponVO = new CouponVO();
			couponVO.setCouponId(couponId);
			couponVO.setCouponName(couponName);
			couponVO.setDiscount(discount);
			couponVO.setDiscountDuration(discountDuration);
			couponVO.setDiscountLimit(discountLimit);
			couponVO.setTriggerThreshold(triggerThreshold);
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponVO", couponVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/admin/coupons/updateCoupon.jsp");
				failureView.forward(req, res);
				return;
			}
			CouponService couponSvc = new CouponService();
			couponVO = couponSvc.updateCoupon(
					couponName, discountDuration, triggerThreshold ,discount, discountLimit, couponId);
			req.setAttribute("couponVO", couponVO);
			String url = "/admin/coupons/listAllCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
			
		
		
}
		
if ("delete".equals(action)) { // 來自listAll.jsp

			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			/***************************1.接收請求參數***************************************/
			Integer couponId = Integer.valueOf(req.getParameter("couponId"));
			
			/***************************2.開始刪除資料***************************************/
			CouponService couponSvc = new CouponService();
			couponSvc.deleteCoupon(couponId);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/admin/coupons/listAllCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
}

		
	}
	
}
