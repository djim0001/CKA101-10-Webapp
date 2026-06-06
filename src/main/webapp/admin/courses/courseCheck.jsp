<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工-課程確認頁面</title>
<style>
span{
	color: red;
}
</style>
</head>
<body>
<h1>課程確認</h1>
<a href='listAllCourse.jsp'><button>課程一覽</button></a>
<table>
	<tr>
		<td>課程名稱：</td>
		<td>${course.courseName}</td>
	</tr>
	<tr>
		<td>心理師編號：</td>
		<td>${course.psychId}</td>
	</tr>
	<tr>
		<td>員工編號：</td>
		<td>${course.adminId}</td>
	</tr>
	<tr>
		<td>課程分類編號：</td>
		<td>${course.courseCatId}</td>
	</tr>
	<tr>
		<td>影片路徑：</td>
		<td>${course.videoSrc}</td>
	</tr>
	<tr>
		<td>預覽影片路徑：</td>
		<td>${course.videoSrcPre}</td>
	</tr>
	<tr>
		<td>課程大綱：</td>
		<td>${course.outline}</td>
	</tr>
	<tr>
 		<td>上架時間：</td>
		<td>${course.listedAt}</td>
	</tr>
	<tr>
		<c:if test="${not empty course.delistedAt}">
    			<td>下架時間：</td>
			<td>${course.delistedAt}</td>
		</c:if>
	</tr>
	<tr>
		<c:if test="${not empty course.delistedAt}">
    			<td>下架原因：</td>
			<td>${course.delistReason}</td>
		</c:if>
	</tr>
	<tr>
		<td>課程狀態：</td>
		<td>${course.courseStatusMsg}</td>
	</tr>
	<tr>
		<td>收藏次數：</td>
		<td>${course.saveCount}</td>
	</tr>
	<tr>
		<td>總星數：</td>
		<td>${course.starCount}</td>
	</tr>
	<tr>
		<td>評價次數：</td>
		<td>${course.reviewCount}</td>
	</tr>
	<tr>
		<td>提問次數：</td>
		<td>${course.commentCount}</td>
	</tr>
<c:if test="${not empty course.psychDiscount}">
	<tr>
		<td>心理師折扣：</td>
		<td>${course.psychDiscount}</td>
	</tr>
	<tr>
		<td>折扣開始時間：</td>
		<td>${course.discountStart}</td>
	</tr>
	<tr>
		<td>折扣結束時間：</td>
		<td>${course.discountEnd}</td>
	</tr>
</c:if>
	
	<tr>
		<td>課程定價：</td>
		<td>${course.price}</td>
	</tr>
</table>
<form>
	<b>審核結果</b>
	<select size="1" name="courseStatus">
		<option value="1" ${1 == course.courseStatus ? "selected" : ""}>待審核</option>
		<option value="2" ${2 == course.courseStatus ? "selected" : ""}>審核成功</option>
		<option value="3" ${3 == course.courseStatus ? "selected" : ""}>審核失敗</option>
		<option value="4" ${4 == course.courseStatus ? "selected" : ""}>已上架</option>
		<option value="5" ${5 == course.courseStatus ? "selected" : ""}>已下架</option>
	</select><br>
	<b>員工編號輸入：</b>
	<input type="text" name="adminId" value="${course.adminId}">
	<span>${errorMsgs.adminId}</span>
	<input type="hidden" name="action" value="course_check">
	<input type="hidden" name=courseId value="${course.courseId}"><br>
	<input type="submit" value="確認送出">
</form>

</body>
</html>