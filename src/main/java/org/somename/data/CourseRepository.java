package org.somename.data;

import java.util.List;

import org.somename.domain.course.Course;

public interface CourseRepository extends BaseRepository<Course, Long> {

	List<Course> findByCourseName(String courseName);

	Course findById(String id);
}