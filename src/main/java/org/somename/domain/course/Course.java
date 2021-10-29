package org.somename.domain.course;

import javax.persistence.Entity;

import org.somename.domain.base.BaseDomainObj;

@Entity
public class Course extends BaseDomainObj {

	private String idCourse;
	private String courseName;
	
    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getFormattedToString() {
        return idCourse+"\t\t"+courseName;
    }

    public static String getFormattedHeader() {
        return "(ID)\t\t(Name)\n--------------------------------------";
    }

    @Override
	public String toString() {
		return String.format(
				"Course[DB id=%d, idCourse='%s', courseName='%s']",
				id, idCourse, courseName);
	}
    
}
