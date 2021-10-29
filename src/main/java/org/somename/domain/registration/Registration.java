package org.somename.domain.registration;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.somename.exceptions.MaxCoursesReachedException;
import org.somename.exceptions.MaxStudentsReachedException;

public class Registration {

    // This class holds the basic Registration data
    // courseid - studentid mapping
    // Since this is not a real DB application, to make easier to search, a duplicate reverse mapping of student-course is also stored.
    // This class can be decomposed into Data and business logic, later.

    private static Registration singleInst = null;


    private Registration() {
    };

    public static Registration getInstance() {
        if(singleInst==null) {
            singleInst = new Registration();
        }
        return singleInst;
    }

    private HashMap<String, ArrayList<String>> courses2Students = new HashMap<String, ArrayList<String>>();
    private HashMap<String, ArrayList<String>> studentsToCourses = new HashMap<String, ArrayList<String>>();

    private short maxStudentsPerCourse = 50;
    private short maxCoursesPerStudent = 5;

    public HashMap<String, ArrayList<String>> getCourses2Students() {
        return courses2Students;
    }

    public HashMap<String, ArrayList<String>> getStudentsToCourses() {
        return studentsToCourses;
    }

    protected void setMockData(HashMap<String, ArrayList<String>> c2s, HashMap<String, ArrayList<String>> s2c) {
        courses2Students = c2s;
        studentsToCourses = s2c;
    }

    public boolean processRegistration(String courseId, String studentId) throws MaxStudentsReachedException, MaxCoursesReachedException {

        if(StringUtils.isEmpty(courseId) || StringUtils.isEmpty(studentId))
            return false;

        boolean res1 = false;
        if(courses2Students.containsKey(courseId)) {
            ArrayList<String> students = courses2Students.get(courseId);

            synchronized (this) {
                if (students.size() < maxStudentsPerCourse) {
                    if (!students.contains(studentId))
                        res1 = students.add(studentId);
                } else {
                    throw new MaxStudentsReachedException("Maximum allowed Students for the course reached. Cannot register.");
                }
            }

        } else {
            ArrayList<String> students = new ArrayList<String>();
            res1 = students.add(studentId);
            courses2Students.put(courseId,students);

        }

        boolean res2 = false;
        if(studentsToCourses.containsKey(studentId)) {
            ArrayList<String> courses = studentsToCourses.get(studentId);

            synchronized (this) {
                if (courses.size() < maxCoursesPerStudent) {
                    if (!courses.contains(courseId))
                        res2 = courses.add(courseId);
                } else {
                    // Remove from the courses2Students as well
                    removePartialRegistration(courseId, studentId);
                    throw new MaxCoursesReachedException("Maximum allowed Courses for the Student reached. Cannot register.");
                }
            }

        } else {
            ArrayList<String> courses = new ArrayList<String>();
            courses.add(courseId);
            studentsToCourses.put(studentId,courses);
            res2 = true;
        }

        return res1 && res2;

    }


    private void removePartialRegistration(String courseId, String studentId) {
        if(courses2Students.containsKey(courseId)) {
            ArrayList<String> students = courses2Students.get(courseId);

            synchronized (this) {
                if (students.contains(studentId))
                    students.remove(studentId);
                if(students.size()==0)
                    courses2Students.remove(courseId);

            }

        }
    }


}
