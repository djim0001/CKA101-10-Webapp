package com.courses.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class CourseHibernateDAO implements CourseDAO_interface{

	private SessionFactory factory;
	public CourseHibernateDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public void insert(Course course) {
		getSession().persist(course);		
	}

	@Override
	public void update(Course course) {
		getSession().merge(course);
		
	}

	@Override
	public void delete(Integer courseId) {
		Course course = getSession().find(Course.class, courseId);
		if (course != null) {
			getSession().remove(course);
		}		
	}

	@Override
	public Course findByPrimaryKey(Integer courseId) {
		return getSession().get(Course.class, courseId);
	}

	@Override
	public List<Course> getAll() {
		return getSession().createQuery("from Course", Course.class).getResultList();
	}

}
