<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>優惠券頁面</title>
		<link rel="stylesheet" href="./css/selectCoupon.css">
	</head>
	<body>
		<h1>搜尋優惠券頁面</h1>

		<a href='addCoupon.jsp'><button>新增優惠券頁面</button></a>
		<a href='listAllCoupon.jsp'><button>全部優惠券頁面</button></a><br>
	
		<jsp:useBean id="couponSvc" scope="page" class="com.coupons.model.CouponService" />
		
		<FORM METHOD="post" ACTION="coupon.do" >
	       <b>選擇優惠券名稱:</b>
	       <select size="1" name="couponId">
	         <c:forEach var="couponVO" items="${couponSvc.all}" > 
	          <option value="${couponVO.couponId}">${couponVO.couponName}</option>
	         </c:forEach>   
	       </select>
	       <input type="hidden" name="action" value="getOne_For_Display">
	       <br>
	       <input type="submit" value="送出">
	    </FORM>
	     
		
		
		
	</body>
</html>