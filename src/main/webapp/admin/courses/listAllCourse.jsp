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
<title>課程一覽-員工</title>
<style>
table{
	font-size: 20px;
}
</style>
</head>
<body>

	<h1>全部課程</h1>
<!-- 	<a href='selectCoupon.jsp'><button>查詢優惠券頁面</button></a> -->
	<br><br>
	
	<div class="pagination pagination-top">
<%-- 	<%@ include file="page1.file" %></div> --%>

	<table>
		<tr>
			<th>課程名稱</th>
			<th>心理師編號</th>
			<th>課程分類編號</th>
			<th>課程狀態</th>
			<th>心理師折扣</th>
			<th>課程定價</th>
			<th>選項</th>
		</tr>
		<c:forEach var="course" items="${list}">
			<c:if test="${course.courseStatus != 0}">
				<tr>
					<td>${course.courseName}</td>
					<td>${course.psychId}</td>
					<td>${course.courseCatId}</td>
					<td>${course.courseStatusMsg}</td>
					<td>${course.psychDiscount == null ? "無" : course.psychDiscount}</td>
					<td>${course.price}</td>
					
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/admin/courses/course.do" style="margin-bottom: 0px;">
						     <input type="submit" value="瀏覽">
						     <input type="hidden" name="courseId"  value="${course.courseId}">
						     <input type="hidden" name="action"	value="select_this">
						</FORM>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		
	</table>
<%-- 	<div class="pagination pagination-bottom"><%@ include file="page2.file" %></div> --%>






</body>
</html>