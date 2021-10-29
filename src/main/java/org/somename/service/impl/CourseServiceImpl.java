package org.somename.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.rainbow.data.DataOperations;
import org.somename.domain.course.Course;
import org.somename.exceptions.CourseNotFoundException;
import org.somename.service.CourseService;

public class CourseServiceImpl implements CourseService {

    DataOperations dao = DataOperations.getInstance();
    @Override
    public Course createCourse(String courseName) {
        if(StringUtils.isEmpty(courseName)) {
            return null;
        }
        Course c = new Course();
        c.setIdCourse(dao.getNextCourseId());
        c.setCourseName(courseName);
        dao.addCourse(c);
        return c;
    }

    @Override
    public boolean deleteCourse(Course c) {
        if(dao.getAllCourses().containsKey(c.getIdCourse())) {
            Course res1 = dao.getAllCourses().remove(c.getIdCourse());
            return (res1.equals(c)) ;
        }
        return false;
    }

    @Override
    public Course getCourse(Course c) {
        return dao.getAllCourses().get(c.getIdCourse());
    }

    @Override
    public List<Course> getAllCourses() {
        return  new ArrayList<Course>(dao.getAllCourses().values());
    }

    @Override
    public Course updateCourse(Course c) {
        if(c==null)
            return c;
        if(dao.getAllCourses().containsKey(c.getIdCourse())) {
            c = dao.getAllCourses().replace(c.getIdCourse(), c);
        }
        return c;
    }

    @Override
    public Course getCourseByName(String courseName) throws CourseNotFoundException {
        if(StringUtils.isEmpty(courseName))
            return null;
        ArrayList<Course> cList = new ArrayList<Course>(dao.getAllCourses().values());
        for(Course c : cList) {
            if(c.getCourseName().equals(courseName))
                return c;
        }
        return null;
    }

    @Override
    public Course getCourseById(String idCourse) {
        if(StringUtils.isEmpty(idCourse))
            return null;
        return dao.getAllCourses().get(idCourse);
    }


}
