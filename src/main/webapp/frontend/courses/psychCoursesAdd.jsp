<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>心理師-課程新增頁面</title>
<style>
span{
	color: red;
}
</style>
</head>
<body>
<h1>課程新增</h1>
<a href='psychCourseAll.jsp'><button>課程一覽</button></a>
<form method="post" action="course.do" name="form1">
<table>
	<tr style="font-size: 20px">
		<td>課程狀態：</td>
		<td>
			<select size="1" name="courseStatus" ${1 == course.courseStatus ? "disabled" : ""}>
				<option value="0">草稿</option>
				<option value="1" ${1 == course.courseStatus ? "selected" : ""}>送出審核</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>課程名稱：</td>
		<td><input type="TEXT" name="courseName" value="" size="45"/></td> <td><font color=red>${errorMsgs.courseName}</font></td>
	</tr>
	<tr>
		<td>心理師編號：</td>
		<td><input type="TEXT" name="psychId" value="" size="45"/></td> <td><font color=red>${errorMsgs.psychId}</font></td>
	</tr>
	<tr>
		<td>課程分類編號：</td>
		<td><input type="TEXT" name="courseCatId" value="" size="45"/></td> <td><font color=red>${errorMsgs.courseCatId}</font></td>
	</tr>
	<tr>
		<td>影片路徑：</td>
		<td><input type="TEXT" name="videoSrc" value="" size="45"/></td> <td><font color=red>${errorMsgs.videoSrc}</font></td>
	</tr>
	<tr>
		<td>預覽影片路徑：</td>
		<td><input type="TEXT" name="videoSrcPre" value="" size="45"/></td> <td><font color=red>${errorMsgs.videoSrcPre}</font></td>
	</tr>
	<tr>
		<td>課程大綱：</td>
		<td><input type="TEXT" name="outline" value="" size="45"/></td> <td><font color=red>${errorMsgs.outline}</font></td>
	</tr>
	<tr>
		<td>課程定價：</td>
		<td><input type="TEXT" name="price" value="" size="45"/></td> <td><font color=red>${errorMsgs.price }</font></td>
	</tr>
	
</table>
<br>
<c:if test="${1 == course.courseStatus ? false : true}">
	<input type="hidden" name="action" value="insert">
	<input type="submit" value="送出">
</c:if>


</FORM>
</body>
</html>