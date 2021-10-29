package org.somename.service;

import java.util.ArrayList;

import org.somename.domain.course.Course;
import org.somename.domain.person.Person;

public interface ReportService {
        public ArrayList<Person> getStudentsForCourse(Course c);
        public ArrayList<Course> getCoursesForStudent(Person s);
        public ArrayList<Person> getStudentsWOCourse();
        public ArrayList<Course> getCoursesWOStudents();

}
