<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>優惠券修改頁面</title>
<link rel="stylesheet" href="./css/updateCoupon.css">
</head>
<body>
<h1>優惠券修改頁面</h1>

<FORM METHOD="post" ACTION="coupon.do" name="form1">
<table>
	<tr>
		<td>優惠券名稱:</td>
		<td><input type="TEXT" name="couponName" value="${couponVO.couponName}" size="45"/></td> <td>${errorMsgs.couponName}</td>
	</tr>
	<tr>
		<td>優惠效期：<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="discountDuration" value="${couponVO.discountDuration}" size="45" readonly/></td>
	</tr>
	<tr>
		<td>消費觸發門檻：<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="triggerThreshold" value="${couponVO.triggerThreshold}" size="45" readonly/></td>
	</tr>
	<tr>
		<td>優惠券折扣：<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="discount" value="${couponVO.discount}" size="45" readonly/></td>
	</tr>
	<tr>
		<td>折扣上限：<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="discountLimit" value="${couponVO.discountLimit}" size="45" readonly/></td>
	</tr>

</table>
<input type="hidden" name="action" value="update">
<input type="hidden" name="couponId" value="${param.couponId}">
<input type="submit" value="送出修改">
</FORM>
<a href='selectCoupon.jsp'><button>查詢優惠券頁面</button></a><br><br>


</body>
</html>