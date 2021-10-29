package org.somename.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.rainbow.data.DataOperations;
import org.somename.domain.course.Course;
import org.somename.domain.person.Person;
import org.somename.service.CourseService;
import org.somename.service.PersonService;
import org.somename.service.ReportService;

public class ReportServiceImpl implements ReportService {

    Registration regrn = Registration.getInstance();
    DataOperations dao = DataOperations.getInstance();
    PersonService psvc = new PersonServiceImpl();
    CourseService csvc = new CourseServiceImpl();
    @Override
    public ArrayList<Person> getStudentsForCourse(Course c) {

        ArrayList<Person> students4Course = null;
        if(c!=null && dao.getAllCourses().containsKey(c.getIdCourse())) {
            HashMap<String, ArrayList<String>> courses2Students = regrn.getCourses2Students();
            ArrayList<String> studentIds = regrn.getCourses2Students().get(c.getIdCourse());
            // Get the details foe the students
            if(studentIds!=null && studentIds.size()>0) {
                students4Course = new ArrayList<Person>();
                Person student;
                for(String studentId: studentIds) {
                    student = psvc.getUserById(studentId);
                    students4Course.add(student);
                }
            }
        }
        return students4Course;
    }

    @Override
    public ArrayList<Course> getCoursesForStudent(Person s) {

        ArrayList<Course> courses4Student = null;
        if(s!=null && dao.getAllStudents().containsKey(s.getIdPerson())) {
            HashMap<String, ArrayList<String>> students2Courses = regrn.getStudentsToCourses();
            ArrayList<String> courseIds = regrn.getStudentsToCourses().get(s.getIdPerson());
            // Get the details foe the students
            if(courseIds!=null && courseIds.size()>0) {
                courses4Student = new ArrayList<Course>();
                Course course;
                for(String courseId: courseIds) {
                    course = csvc.getCourseById(courseId);
                    courses4Student.add(course);
                }
            }
        }
        return courses4Student;
    }

    @Override
    public ArrayList<Person> getStudentsWOCourse() {
        ArrayList<Person> studentsWOCourse = null;
        ArrayList<String> studentIdsWCourses = new ArrayList<String>(regrn.getStudentsToCourses().keySet());
        ArrayList<String> allStudentIds = new ArrayList<String>(dao.getAllStudents().keySet());
        if(allStudentIds.removeAll(studentIdsWCourses)) {
            studentsWOCourse = new ArrayList<Person>();
            Person student;
            // allStudentIds will now have only students WO Courses
            for(String studentId : allStudentIds) {
                student = psvc.getUserById(studentId);
                studentsWOCourse.add(student);
            }
        };

        return studentsWOCourse;
    }

    @Override
    public ArrayList<Course> getCoursesWOStudents() {

        ArrayList<Course> coursesWOStudents = null;
        ArrayList<String> courseIdsWStudents = new ArrayList<String>(regrn.getCourses2Students().keySet());
        ArrayList<String> allCourseIds = new ArrayList<String>(dao.getAllCourses().keySet());
        if(allCourseIds.removeAll(courseIdsWStudents)) {
            coursesWOStudents = new ArrayList<Course>();
            Course course;
            // allCourseIds will now have only Courses WO students
            for(String courseId: allCourseIds) {
                course = csvc.getCourseById(courseId);
                coursesWOStudents.add(course);
            }
        };

        return coursesWOStudents;
    }
}
