package org.somename.mock.data;

import java.util.ArrayList;

import org.somename.Util.ReadDataFiles;
import org.somename.constants.F2I_C;
import org.somename.domain.course.Course;
import org.somename.domain.person.Person;
import org.somename.domain.security.Credentials;
import org.somename.domain.security.User;

public class MockDataHelper {

    /**
        This method returns all the Students list.
        For now, based on the initial parameters, it will get it from a file based list
        It can be changed per requirements to DB or LDAP later.
     */

    public static ArrayList<Person> getAllStudents() {

        ArrayList<Person> studentList = new ArrayList<Person>();
        ReadDataFiles.loadObjectsFromFile(Person.class, studentList,
                "C:\\zWork\\code\\workspaces\\Intellij-Ult\\Fun2Imagine\\src\\org\\rainbow\\mock\\Students.list",
                new String[] {"setIdPerson","setFirstName","setLastName","setType"}, "\t");
        if(F2I_C.printDebug) System.out.println("STUDENTS ============="+studentList.size());
        return studentList;
    }

    public static ArrayList<Person> getAllFaculty() {

        ArrayList<Person> facultyList = new ArrayList<Person>();
        ReadDataFiles.loadObjectsFromFile(Person.class, facultyList,
                "C:\\zWork\\code\\workspaces\\Intellij-Ult\\Fun2Imagine\\src\\org\\rainbow\\mock\\Faculty.list",
                new String[] {"setIdPerson","setFirstName","setLastName","setType"}, "\t");
        if(F2I_C.printDebug) System.out.println("FACULTY ============="+facultyList.size());
        return facultyList;
    }

    public static ArrayList<Course> getAllCourses() {

        ArrayList<Course> courseList = new ArrayList<Course>();
        ReadDataFiles.loadObjectsFromFile(Course.class, courseList,
                "C:\\zWork\\code\\workspaces\\Intellij-Ult\\Fun2Imagine\\src\\org\\rainbow\\mock\\Courses.list",
                new String[] {"setIdCourse","setCourseName"}, "\t");
        if(F2I_C.printDebug) System.out.println("COURSES ============="+courseList.size());
        return courseList;
    }

    public static ArrayList<User> getAllUsers() {

        ArrayList<User> userList = new ArrayList<User>();
        ReadDataFiles.loadObjectsFromFile(User.class, userList,
                "C:\\zWork\\code\\workspaces\\Intellij-Ult\\Fun2Imagine\\src\\org\\rainbow\\mock\\Users.list",
                new String[] {"setUserLogin","setUserType","setIdPerson"}, "\t");
        if(F2I_C.printDebug) System.out.println("Users ============="+ userList.size());
        return userList;
    }


    public static ArrayList<Credentials> getAllCredentials() {

        ArrayList<Credentials> credentialsList = new ArrayList<Credentials>();
        ReadDataFiles.loadObjectsFromFile(Credentials.class, credentialsList,
                "C:\\zWork\\code\\workspaces\\Intellij-Ult\\Fun2Imagine\\src\\org\\rainbow\\mock\\Credentials.list",
                new String[] {"setUserLogin","setEncodedPw"}, "\t");
        if(F2I_C.printDebug) System.out.println("Credentials ============="+credentialsList.size());
        return credentialsList;
    }

}
