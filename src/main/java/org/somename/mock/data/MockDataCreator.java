package org.somename.mock.data;

import java.util.ArrayList;
import java.util.HashMap;

import org.somename.domain.course.Course;
import org.somename.domain.person.Person;
import org.somename.domain.security.Credentials;
import org.somename.domain.security.User;

public class MockDataCreator {

    // This will hold the data in Memory for the application.
    // This package will be replaced with the Data Access package to store the data in a database later.

    private static MockDataCreator singleInst = null;

    private MockDataCreator() {
    };

    public static MockDataCreator getInstance() {
        if(singleInst==null) {
            singleInst = new MockDataCreator();
        }
        return singleInst;
    }


    // Key to all these Maps will be the IDs
    private HashMap<String, Person> allStudents;
    private HashMap<String, Person> allFaculty;
    private HashMap<String, Person> allPersons;
    private HashMap<String, Course> allCourses;
    private HashMap<String, User> allUsersById;
    // Key - userLogin, Value - encoded PW
    private HashMap<String, User> allUsersByLogin;
    private HashMap<String,String> allCreds;

    public void initialize() {

        allStudents = new HashMap<String, Person>();
        allFaculty = new HashMap<String, Person>();
        allPersons = new HashMap<String, Person>();
        allCourses = new HashMap<String, Course>();
        allUsersById = new HashMap<String, User>();
        allUsersByLogin = new HashMap<String, User>();
        allCreds = new HashMap<String, String>();

        ArrayList<Person> studentList = MockDataHelper.getAllStudents();
        for(Person p: studentList)
            allStudents.put(p.getIdPerson(),p);

        ArrayList<Person> facultyList = MockDataHelper.getAllFaculty();
        for(Person p: facultyList)
            allFaculty.put(p.getIdPerson(),p);

        allPersons.putAll(allStudents);
        allPersons.putAll(allFaculty);

        ArrayList<Course> courseList = MockDataHelper.getAllCourses();
        for(Course c: courseList)
            allCourses.put(c.getIdCourse(), c);

        ArrayList<User> userList = MockDataHelper.getAllUsers();
        for(User u: userList) {
            allUsersById.put(u.getIdPerson(), u);
            allUsersByLogin.put(u.getUserLogin(), u);
        }

        ArrayList<Credentials> credList = MockDataHelper.getAllCredentials();
        for(Credentials cr: credList)
            allCreds.put(cr.getUserLogin(), cr.getEncodedPw());

    }

    public synchronized String getNextStudentId() {
        return "s"+(allStudents.size()+1);
    }

    public synchronized String getNextFacultyId() {
        return "f"+(allFaculty.size()+1);
    }

    public synchronized String getNextCourseId() {
        return "c"+(allCourses.size()+1);
    }

    public Person addStudent(Person p) {
        allStudents.put(p.getIdPerson(),p);
        allPersons.put(p.getIdPerson(),p);

        return p;
    }

    public Person addFacuty(Person p) {
        allFaculty.put(p.getIdPerson(),p);
        allPersons.put(p.getIdPerson(),p);
        return p;
    }

    public void processAddUserLogin(String userLogin, String pwEncoded, User u) {
        allCreds.put(userLogin, pwEncoded);
        allUsersById.put(u.getIdPerson(),u);
        allUsersByLogin.put(userLogin,u);
    }

    public void processDeleteUserLogin(Person p) {
        String userLogin = allUsersById.get(p.getIdPerson()).getUserLogin();
        allCreds.remove(userLogin);
        allUsersById.remove(p.getIdPerson());
        allUsersByLogin.remove(userLogin);
    }

    public Course addCourse(Course c) {
        allCourses.put(c.getIdCourse(),c);
        return c;
    }




    private void writeDataToMemory() {
        // This is a Mock Method that need not be implemented now.
        // Database persistence will make this obsolete.
    }



    public HashMap<String, Person> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(HashMap<String, Person> allStudents) {
        this.allStudents = allStudents;
    }

    public HashMap<String, Person> getAllFaculty() {
        return allFaculty;
    }

    public void setAllFaculty(HashMap<String, Person> allFaculty) {
        this.allFaculty = allFaculty;
    }
    public HashMap<String, Person> getAllPersons() {
        return allPersons;
    }

    public void setAllPersons(HashMap<String, Person> allPersons) {
        this.allPersons = allPersons;
    }
    public HashMap<String, Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(HashMap<String, Course> allCourses) {
        this.allCourses = allCourses;
    }

    public HashMap<String, User> getAllUsersById() {
        return allUsersById;
    }

    public void setAllUsersById(HashMap<String, User> allUsersById) {
        this.allUsersById = allUsersById;
    }

    public HashMap<String, String> getAllCreds() {
        return allCreds;
    }

    public void setAllCreds(HashMap<String, String> allCreds) {
        this.allCreds = allCreds;
    }

    public HashMap<String, User> getAllUsersByLogin() {
        return allUsersByLogin;
    }

    public void setAllUsersByLogin(HashMap<String, User> allUsersByLogin) {
        this.allUsersByLogin = allUsersByLogin;
    }
}
