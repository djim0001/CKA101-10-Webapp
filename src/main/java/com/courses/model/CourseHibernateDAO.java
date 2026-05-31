package com.courses.model;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class CourseHibernateDAO implements CourseDAO_interface{

	private static final String INSERT = "";
	private static final String GET_ALL = "FROM Course";
	private static final String GET_ONE = "";
	private static final String DELETE = "";
	private static final String UPDATE = 
			"UPDATE Course "
			+ "SET courseName = "
			+ "WHERE CourseId";
	
	@Override
	public void insert(Course Course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Course Course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findByPrimaryKey(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Course> courseList = null;
		try {
			session.beginTransaction();
			courseList = session.createQuery(GET_ALL, Course.class).getResultList();
			
//			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
		return courseList;
	}

}
