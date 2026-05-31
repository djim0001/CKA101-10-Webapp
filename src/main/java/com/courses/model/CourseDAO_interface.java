package com.courses.model;

import java.util.List;


public interface CourseDAO_interface {
	public void insert(Course Course);
    public void update(Course Course);
    public void delete(Integer courseId);
    public Course findByPrimaryKey(Integer courseId);
    public List<Course> getAll();
}
