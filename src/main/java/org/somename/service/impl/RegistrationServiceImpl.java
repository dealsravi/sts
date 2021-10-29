package org.somename.service.impl;

import org.somename.exceptions.MaxCoursesReachedException;
import org.somename.exceptions.MaxStudentsReachedException;
import org.somename.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

    Registration reg = Registration.getInstance();
    @Override
    public boolean registerStudentToCourse(String courseId, String studentId) throws MaxStudentsReachedException, MaxCoursesReachedException {
        return reg.processRegistration(courseId, studentId);
    }
}
