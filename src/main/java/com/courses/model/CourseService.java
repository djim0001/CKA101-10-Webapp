package com.courses.model;

import java.sql.Date;
import java.util.List;

public class CourseService {
	private CourseDAO_interface dao;
	
	public CourseService() {
		dao = new CourseHibernateDAO();
	}
	
	public Course addCourse(
			String courseName, Integer psychId, Integer adminId, Integer courseCatId, 
			String videoSrc, String videoSrcPre, String outline, Date listedAt, 
			Date delistedAt, String delistReason, String courseStatus, Integer saveCount, 
			Integer starCount, Integer reviewCount, Integer commentCount, 
			Double psychDiscount, Date discountStart, Date discountEnd, Integer price
			) {
		Course course = new Course();
		
		
		
		
		
		return course;
	}
	
	public Course updateCourse() {
		return null;
	}
	
	public void deleteCourse() {
		
	}
	
	public Course getOneCourse() {
		return null;
	}
	
	public List<Course> getAll(){
		return dao.getAll();
	}
	
	
	
}
