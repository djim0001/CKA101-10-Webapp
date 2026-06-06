package com.courses.model;

import java.util.List;

public class CourseService {
	private CourseDAO_interface dao;
	
	public CourseService() {
		dao = new CourseHibernateDAO();
	}
	
	public Course addCourse(
			String courseName, Integer psychId, Integer courseCatId, 
			String videoSrc, String videoSrcPre, String outline, 
			Byte courseStatus, Integer saveCount, Integer starCount, 
			Integer reviewCount, Integer commentCount, Integer price
			) {
		Course course = new Course();
		course.setCourseName(courseName);
		course.setPsychId(psychId);
		course.setCourseCatId(courseCatId);
		course.setVideoSrc(videoSrc);
		course.setVideoSrcPre(videoSrcPre);
		course.setOutline(outline);
		course.setCourseStatus(courseStatus);
		course.setSaveCount(saveCount);
		course.setStarCount(starCount);
		course.setReviewCount(reviewCount);
		course.setCommentCount(commentCount);
		course.setPrice(price);
		dao.insert(course);
		
		return course;
	}
	
	public Course updateCourse(
			String courseName, Integer psychId, Integer courseCatId, 
			String videoSrc, String videoSrcPre, String outline, 
			Byte courseStatus, Integer saveCount, Integer starCount, 
			Integer reviewCount, Integer commentCount, Integer price
			) {
		Course course = new Course();
		course.setCourseName(courseName);
		course.setPsychId(psychId);
		course.setCourseCatId(courseCatId);
		course.setVideoSrc(videoSrc);
		course.setVideoSrcPre(videoSrcPre);
		course.setOutline(outline);
		course.setCourseStatus(courseStatus);
		course.setSaveCount(saveCount);
		course.setStarCount(starCount);
		course.setReviewCount(reviewCount);
		course.setCommentCount(commentCount);
		course.setPrice(price);
		dao.update(course);
		
		return course;
	}
	
	public Course checkCourse(Integer courseId, Integer adminId, Byte checkNum) {
		Course course = getOneCourse(courseId);
		course.setAdminId(adminId);
		course.setCourseStatus(checkNum);
		dao.update(course);
		
		return course;
	}
	
	public void deleteCourse(Integer courseId) {
		dao.delete(courseId);
	}
	
	public Course getOneCourse(Integer courseId) {
		return dao.findByPrimaryKey(courseId);
	}
	
	public List<Course> getAll(){
		return dao.getAll();
	}
	
	
	
}
