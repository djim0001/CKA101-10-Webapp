<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.coupons.model.*"%>

<%
    CouponService couponSvc = new CouponService();
    List<CouponVO> list = couponSvc.getAll();
    pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全部優惠券頁面</title> 
<link rel="stylesheet" href="css/listAllCoupon.css">

</head>
<body>

	<h2>全部優惠券</h2>
	<a href='selectCoupon.jsp'><button>查詢優惠券頁面</button></a><br><br>
	
	<div class="pagination pagination-top"><%@ include file="page1.file" %></div>

	<table>
		<tr>
			<th>優惠券名稱</th>
			<th>優惠效期(天)</th>
			<th>消費觸發門檻</th>
			<th>優惠券折扣</th>
			<th>折扣上限</th>
			<th>其他功能</th>
		</tr>
		<c:forEach var="couponVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${couponVO.couponName}</td>
				<td>${couponVO.discountDuration}</td>
				<td>${couponVO.triggerThreshold}</td>
				<td>${couponVO.discount}</td>
				<td>${couponVO.discountLimit}</td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/admin/coupons/coupon.do" style="margin-bottom: 0px;">
					     <input type="submit" value="修改">
					     <input type="hidden" name="couponId"  value="${couponVO.couponId}">
					     <input type="hidden" name="action"	value="getOne_For_Update">
					</FORM>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/admin/coupons/coupon.do" style="margin-bottom: 0px;">
					     <input type="submit" value="刪除">
					     <input type="hidden" name="couponId"  value="${couponVO.couponId}">
					     <input type="hidden" name="action"	value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<div class="pagination pagination-bottom"><%@ include file="page2.file" %></div>
</body>
</html>
