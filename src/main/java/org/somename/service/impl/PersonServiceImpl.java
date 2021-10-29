package org.somename.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.rainbow.data.DataOperations;
import org.rainbow.domain.person.enums.PersonTypes;
import org.somename.data.PersonRepository;
import org.somename.domain.person.Person;
import org.somename.domain.security.User;
import org.somename.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {

    //DataOperations dao = DataOperations.getInstance();
	@Autowired
	private PersonRepository pRepo;
	
    @Override
    public Person getUserByLogin(String userLogin) {
        if(StringUtils.isEmpty(userLogin))
            return null;
        User p = dao.getAllUsersByLogin().get(userLogin);
        return dao.getAllPersons().get(p.getIdPerson());
    }

    @Override
    public Person getUserById(String personId) {
        return dao.getAllPersons().get(personId);
    }

    @Override
    public Person createPerson(String userLogin, String firstName, String lastName, String pwEncoded, String type) {
        Person p = new Person();
        p.setTypeStr(type);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        if(type.equalsIgnoreCase(String.valueOf(PersonTypes.student))) {
            p.setIdPerson(dao.getNextStudentId());
            dao.addStudent(p);
        } else if(type.equalsIgnoreCase(String.valueOf(PersonTypes.faculty))) {
            p.setIdPerson(dao.getNextFacultyId());
            dao.addFacuty(p);
        }

        User u = new User();
        u.setIdPerson(p.getIdPerson());
        u.setUserType(type);
        u.setUserLogin(userLogin);
        dao.processAddUserLogin(userLogin, pwEncoded, u);

        return p;
    }

    @Override
    public Person createStudent(String userLogin, String firstName, String lastName, String pwEncoded) {
        return createPerson(userLogin, firstName, lastName, pwEncoded, "student");
    }

    @Override
    public Person createFaculty(String userLogin, String firstName, String lastName, String pwEncoded) {
        return createPerson(userLogin, firstName, lastName, pwEncoded, "faculty");
    }

    @Override
    public Person updatePerson(Person person) {
        if(person.getType().equals(PersonTypes.student)) {
            if(dao.getAllStudents().containsKey(person.getIdPerson())) {
                person = dao.getAllStudents().replace(person.getIdPerson(), person);
                dao.getAllPersons().replace(person.getIdPerson(), person);
            }
        } else if(person.getType().equals(PersonTypes.faculty)) {
            person = dao.getAllFaculty().replace(person.getIdPerson(), person);
            dao.getAllPersons().replace(person.getIdPerson(), person);
        }
        return person;
    }

    @Override
    public boolean deletePerson(Person person) {
        if(person.getType().equals(PersonTypes.student)) {

            if(dao.getAllStudents().containsKey(person.getIdPerson())) {
                Person res1 = dao.getAllStudents().remove(person.getIdPerson());
                Person res2 = dao.getAllPersons().remove(person.getIdPerson());
                dao.processDeleteUserLogin(person);
                return (res1.equals(person)) && (res2.equals(person));
            }
        } else if(person.getType().equals(PersonTypes.faculty)) {

            if(dao.getAllFaculty().containsKey(person.getIdPerson())) {
                Person res1 = dao.getAllFaculty().remove(person.getIdPerson());
                Person res2 = dao.getAllPersons().remove(person.getIdPerson());
                dao.processDeleteUserLogin(person);
                return (res1.equals(person)) && (res2.equals(person));
            }
        }
        return false;
    }

}
