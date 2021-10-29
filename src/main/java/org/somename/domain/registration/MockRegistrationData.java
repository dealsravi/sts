package org.somename.domain.registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MockRegistrationData {

    public static void mockRegistrationData(HashMap<String, ArrayList<String>> c2s, HashMap<String, ArrayList<String>> s2c) {
        Registration.getInstance().setMockData(c2s, s2c);
    }

    public static void initialize() {

        ArrayList<String> c1Students =  new ArrayList<String>(Arrays.asList(new String[] {"s1","s2","s3","s4","s5"}));
        ArrayList<String> c2Students = new ArrayList<String>(Arrays.asList(new String[] {"s1","s2","s3"}));
        ArrayList<String> c3Students = new ArrayList<String>(Arrays.asList(new String[] {"s1","s4","s5"}));
        ArrayList<String> c4Students = new ArrayList<String>(Arrays.asList(new String[] {"s1","s5"}));
        ArrayList<String> c5Students = new ArrayList<String>(Arrays.asList(new String[] {"s3","s4","s5"}));

        HashMap<String, ArrayList<String>> courses2Students = new HashMap<String, ArrayList<String>>();
        courses2Students.put("c1",c1Students);
        courses2Students.put("c2",c2Students);
        courses2Students.put("c3",c3Students);
        courses2Students.put("c4",c4Students);
        courses2Students.put("c5",c5Students);

        ArrayList<String> s1Courses = new ArrayList<String>(Arrays.asList(new String[] {"c1","c2","c3","c4"}));
        ArrayList<String> s2Courses = new ArrayList<String>(Arrays.asList(new String[] {"c1","c2"}));
        ArrayList<String> s3Courses = new ArrayList<String>(Arrays.asList(new String[] {"c1","c2","c5"}));
        ArrayList<String> s4Courses = new ArrayList<String>(Arrays.asList(new String[] {"c1","c3","c4"}));
        ArrayList<String> s5Courses = new ArrayList<String>(Arrays.asList(new String[] {"c1","c3","c4","c5"}));
        HashMap<String, ArrayList<String>> students2Courses = new HashMap<String, ArrayList<String>>();
        students2Courses.put("s1",s1Courses);
        students2Courses.put("s2",s2Courses);
        students2Courses.put("s3",s3Courses);
        students2Courses.put("s4",s4Courses);
        students2Courses.put("s5",s5Courses);

        mockRegistrationData(courses2Students,students2Courses);
    }

}
