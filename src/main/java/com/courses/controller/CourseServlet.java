package com.courses.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.courses.model.Course;
import com.courses.model.CourseService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({"/admin/courses/course.do","/frontend/courses/course.do"})
public class CourseServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if("select_this".equals(action)) {
			Integer courseId = Integer.valueOf(req.getParameter("courseId"));
			CourseService courseSvc = new CourseService();
			Course course = courseSvc.getOneCourse(courseId);
			
			req.setAttribute("course", course);
			String url = "/admin/courses/courseCheck.jsp";
			res.setContentType("text/html; charset=UTF-8");
			RequestDispatcher selectThisView = req.getRequestDispatcher(url);
			selectThisView.forward(req, res);
			
		}
		
		if("course_check".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			Byte courseStatus = Byte.valueOf(req.getParameter("courseStatus"));
			Integer courseId = Integer.valueOf(req.getParameter("courseId"));
			String str = req.getParameter("adminId");
			String urlFail = "/admin/courses/courseCheck.jsp";
			String urlSuccess = "/admin/courses/listAllCourse.jsp";
			CourseService courseSvc = new CourseService();
			if(str == null || (str.trim().length() == 0)) {
				errorMsgs.put("adminId", "請輸入員工編號");
			}
			if (!errorMsgs.isEmpty()) {
				Course course = courseSvc.getOneCourse(courseId);
				req.setAttribute("course", course);
				RequestDispatcher failureView = req
						.getRequestDispatcher(urlFail);
				failureView.forward(req, res);
				return;//程式中斷
			}
			Integer adminId = null;
			try {
				adminId = Integer.valueOf(str);
			}catch(Exception e) {
				errorMsgs.put("adminId", "員工編號請輸入數字");
			}
			if (!errorMsgs.isEmpty()) {
				Course course = courseSvc.getOneCourse(courseId);
				req.setAttribute("course", course);
				RequestDispatcher failureView = req
						.getRequestDispatcher(urlFail);
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			// 查詢是否有此員工
			
			
			
			
			
			Course course = courseSvc.checkCourse(courseId, adminId, courseStatus);
			
			req.setAttribute("course", course);
			res.setContentType("text/html; charset=UTF-8");
			RequestDispatcher selectThisView = req.getRequestDispatcher(urlSuccess);
			selectThisView.forward(req, res);
		}
		
		if("insert".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			String courseName = req.getParameter("courseName");
			if(courseName == null || courseName.trim().length() == 0) {
				errorMsgs.put("courseName", "課程名稱: 請勿空白");
			}
			
			Integer psychId = null;
			try {
				psychId = Integer.valueOf(req.getParameter("psychId"));
			}catch(NumberFormatException e) {
				psychId = 0;
				errorMsgs.put("psychId", "心理師編號請填數字");
			}
			if (psychId < 0) {
				errorMsgs.put("psychId", "心理師編號請填大於 0 的數字");
			}
			
			Integer courseCatId = null;
			try {
				courseCatId = Integer.valueOf(req.getParameter("courseCatId"));
			}catch(NumberFormatException e) {
				courseCatId = 0;
				errorMsgs.put("courseCatId", "課程分類編號請填數字");
			}
			if (courseCatId < 0) {
				errorMsgs.put("courseCatId", "課程分類編號請填大於 0 的數字");
			}
			
			String videoSrc = req.getParameter("videoSrc");
			if(videoSrc == null || videoSrc.trim().length() == 0) {
				errorMsgs.put("videoSrc", "影片路徑: 請勿空白");
			}
			String videoSrcPre = req.getParameter("videoSrc");
			if(videoSrcPre == null || videoSrcPre.trim().length() == 0) {
				errorMsgs.put("videoSrcPre", "影片預覽路徑: 請勿空白");
			}
			String outline = req.getParameter("outline");
			if(outline == null || outline.trim().length() == 0) {
				errorMsgs.put("outline", "課程大綱: 請勿空白");
			}
			
			Integer price = null;
			try {
				price = Integer.valueOf(req.getParameter("price"));
			}catch(NumberFormatException e) {
				price = 0;
				errorMsgs.put("price", "課程定價請填數字");
			}
			if (price < 0) {
				errorMsgs.put("price", "課程定價請填大於 0 的數字");
			}
			
			Course course = new Course();
			course.setCourseName(courseName);
			course.setPsychId(psychId);
			course.setCourseCatId(courseCatId);
			course.setVideoSrc(videoSrc);
			course.setVideoSrcPre(videoSrcPre);
			course.setOutline(outline);
			course.setPrice(price);
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("course", course);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/frontend/courses/psychCourseAdd.jsp");
				failureView.forward(req, res);
				return;
			}
			CourseService courseSvc = new CourseService();
			course = courseSvc.addCourse(
					courseName, psychId, courseCatId, videoSrc, 
					videoSrcPre, outline, (byte) 1, 0, 0, 0, 0, price);
			RequestDispatcher successView = req.getRequestDispatcher("/frontend/courses/psychCoursesAll.jsp");
			successView.forward(req, res);
			
		}
		
		if("draft".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			String courseName = req.getParameter("courseName");
			if(courseName == null || courseName.trim().length() == 0) {
				errorMsgs.put("courseName", "課程名稱: 請勿空白");
			}
			
			Integer psychId = null;
			try {
				psychId = Integer.valueOf(req.getParameter("psychId"));
			}catch(NumberFormatException e) {
				psychId = 0;
			}
			
			Integer courseCatId = null;
			try {
				courseCatId = Integer.valueOf(req.getParameter("courseCatId"));
			}catch(NumberFormatException e) {
				courseCatId = 0;
			}
			
			String videoSrc = req.getParameter("videoSrc");
			if(videoSrc == null || videoSrc.trim().length() == 0) {
				videoSrc = "";
			}
			String videoSrcPre = req.getParameter("videoSrc");
			if(videoSrcPre == null || videoSrcPre.trim().length() == 0) {
				videoSrcPre = "";				
			}
			String outline = req.getParameter("outline");
			if(outline == null || outline.trim().length() == 0) {
				outline = "";
			}
			
			Integer price = null;
			try {
				price = Integer.valueOf(req.getParameter("price"));
			}catch(NumberFormatException e) {
				price = 0;
			}
			
			Course course = new Course();
			course.setCourseName(courseName);
			course.setPsychId(psychId);
			course.setCourseCatId(courseCatId);
			course.setVideoSrc(videoSrc);
			course.setVideoSrcPre(videoSrcPre);
			course.setOutline(outline);
			course.setPrice(price);
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("course", course);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/frontend/courses/psychCourseAdd.jsp");
				failureView.forward(req, res);
				return;
			}
			CourseService courseSvc = new CourseService();
			course = courseSvc.addCourse(
					courseName, psychId, courseCatId, videoSrc, 
					videoSrcPre, outline, (byte) 0, 0, 0, 0, 0, price);
			RequestDispatcher successView = req.getRequestDispatcher("/frontend/courses/psychCoursesAll.jsp");
			successView.forward(req, res);
			
		}
		
		
		
		
		
		
		
	}
	
}
