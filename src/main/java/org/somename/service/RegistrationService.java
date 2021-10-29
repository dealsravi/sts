package org.somename.service;

import org.somename.exceptions.MaxCoursesReachedException;
import org.somename.exceptions.MaxStudentsReachedException;

public interface RegistrationService {
    
    public boolean registerStudentToCourse(String courseId, String studentId) throws MaxStudentsReachedException, MaxCoursesReachedException;
}
