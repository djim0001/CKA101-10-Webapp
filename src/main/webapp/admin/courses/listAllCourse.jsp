<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.courses.model.*"%>

<%
	CourseService courseSvc = new CourseService();
    List<Course> list = courseSvc.getAll();
    pageContext.setAttribute("list", list);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課程一覽</title>
</head>
<body>

	<h2>全部課程</h2>
<!-- 	<a href='selectCoupon.jsp'><button>查詢優惠券頁面</button></a> -->
	<br><br>
	
	<div class="pagination pagination-top">
<%-- 	<%@ include file="page1.file" %></div> --%>

	<table>
		<tr>
			<th>課程名稱</th>
			<th>心理師編號</th>
			<th>員工編號</th>
			<th>課程分類編號</th>
			<th>影片路徑</th>
			<th>預覽影片路徑</th>
			<th>課程大綱</th>
			<th>上架時間</th>
			<th>下架時間</th>
			<th>下架原因</th>
			<th>課程狀態</th>
			<th>收藏次數</th>
			<th>總星數</th>
			<th>評價次數</th>
			<th>提問次數</th>
			<th>心理師折扣</th>
			<th>折扣開始時間</th>
			<th>折扣結束時間</th>
			<th>課程定價</th>
		</tr>
		<c:forEach var="course" items="${list}">
			<tr>
				<td>${course.courseName}</td>
				<td>${course.psychId}</td>
				<td>${course.adminId}</td>
				<td>${course.courseCatId}</td>
				<td>${course.videoSrc}</td>
				<td>${course.videoSrcPre}</td>
				<td>${course.outline}</td>
				<td>${course.listedAt}</td>
				<td>${course.delistedAt}</td>
				<td>${course.delistReason}</td>
				<td>${course.courseStatus}</td>
				<td>${course.saveCount}</td>
				<td>${course.starCount}</td>
				<td>${course.reviewCount}</td>
				<td>${course.commentCount}</td>
				<td>${course.psychDiscount}</td>
				<td>${course.discountStart}</td>
				<td>${course.discountEnd}</td>
				<td>${course.price}</td>
				
				
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/admin/course/course.do" style="margin-bottom: 0px;">
					     <input type="submit" value="修改">
					     <input type="hidden" name="courseId"  value="${course.courseId}">
					     <input type="hidden" name="action"	value="getOne_For_Update">
					</FORM>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/admin/course/course.do" style="margin-bottom: 0px;">
					     <input type="submit" value="刪除">
					     <input type="hidden" name="courseId"  value="${course.courseId}">
					     <input type="hidden" name="action"	value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
		
	</table>
<%-- 	<div class="pagination pagination-bottom"><%@ include file="page2.file" %></div> --%>






</body>
</html>