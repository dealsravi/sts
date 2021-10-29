package org.somename.domain.person;

import java.util.Objects;

import javax.persistence.Entity;

import org.somename.domain.base.BaseDomainObj;
import org.somename.domain.course.Course;

@Entity
public class Person extends BaseDomainObj {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO) private long id; public long
	 * getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 */
	
	private String idPerson;
	private String firstName;
	private String lastName;
	private String type;


	public String getName() {
        return firstName+" "+lastName;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormattedToString(boolean includeType) {
        if(includeType)
            return type.toString().toUpperCase()+"\t\t"+id+"\t\t"+firstName+" "+lastName;
        else
            return id+"\t\t"+firstName+" "+lastName;
    }

    public static String getFormattedHeader(boolean includeType) {
        if(includeType)
            return "Type\t\t(ID)\t\tName\n----------------------------------------------";
        else
            return "(ID)\t\t(Name)\n----------------------------------------------";
    }

    @Override
	public String toString() {
		return String.format(
				"Person[DB id=%d, personId='%s', type='%s',  firstName='%s', lastName='%s']",
				id, idPerson, type, firstName, lastName);
	}
    
    



}
