<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增優惠券</title>
<link rel="stylesheet" href="./css/addCoupon.css">
</head>
<body>
	<h1>新增優惠券頁面</h1>
	<a href='selectCoupon.jsp'><button>查詢優惠券頁面</button></a><br><br>
	<form method="post" action="coupon.do" name="form1">
		<table>
			<tr>	
				<td>優惠券名稱<font color=red> *</font>：</td>
				<td><input type="TEXT" name="couponName" value="" size="45"/></td> <td><font color=red>${errorMsgs.couponName}</font></td>
			</tr>
			<tr>	
				<td>優惠效期<font color=red> *</font>：</td>
				<td><input type="TEXT" name="discountDuration" value="" size="45"/></td> <td><font color=red>${errorMsgs.discountDuration}</font></td>
			</tr>
			<tr>	
				<td>消費觸發門檻：</td>
				<td><input type="TEXT" name="triggerThreshold" value="" size="45"/></td> <td><font color=red>${errorMsgs.triggerThreshold}</font></td>
			</tr>
			<tr>	
				<td>優惠券折扣<font color=red> *</font>：</td>
				<td><input type="TEXT" name="discount" value="" size="45"/></td> <td><font color=red>${errorMsgs.discount}</font></td>
			</tr>
			<tr>	
				<td>折扣上限</td>
				<td><input type="TEXT" name="discountLimit" value="" size="45"/></td> <td><font color=red>${errorMsgs.discountLimit}</font></td>
			</tr>
			<jsp:useBean id="CouponSvc" scope="page" class="com.coupons.model.CouponService" />
			
		</table>
		<br>
		<input type="hidden" name="action" value="insert">
		<input type="submit" value="送出新增"></FORM>
	</form>
</body>
</html>