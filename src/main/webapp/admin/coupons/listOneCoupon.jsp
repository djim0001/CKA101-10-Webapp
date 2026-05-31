<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>優惠券資料</title>
<link rel="stylesheet" href="./css/listOneCoupon.css">
<style>
	table {
		width: 600px;
		background-color: white;
		margin-top: 5px;
		margin-bottom: 5px;
	  }
	table, th, td {
    		border: 1px solid #CCCCFF;
  	}
  	th, td {
	    padding: 5px;
	    text-align: center;
  	}
</style>
</head>
<body>
	<h1>優惠券資料：</h1>
	<table>
		<tr>
			<th>優惠券名稱</th>
			<th>優惠效期(天)</th>
			<th>消費觸發門檻</th>
			<th>優惠券折扣</th>
			<th>折扣上限</th>
		</tr>
		<tr>
			<th>${couponVO.couponName}</th>
			<th>${couponVO.discountDuration}</th>
			<th>${couponVO.triggerThreshold}</th>
			<th>${couponVO.discount}</th>
			<th>${couponVO.discountLimit}</th>
		</tr>
	</table>
	<a href='selectCoupon.jsp'><button>返回查詢頁</button></a>
</body>
</html>