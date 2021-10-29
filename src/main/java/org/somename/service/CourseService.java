package org.somename.service;

import java.util.List;

import org.somename.domain.course.Course;
import org.somename.exceptions.CourseNotFoundException;

public interface CourseService {

    public Course createCourse(String courseName);
    public boolean deleteCourse(Course c);
    public Course getCourse(Course c);
    public List<Course> getAllCourses();
    public Course updateCourse(Course c);
    public Course getCourseByName(String courseName) throws CourseNotFoundException;
    public Course getCourseById(String idCourse);
}
