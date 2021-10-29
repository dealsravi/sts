package org.somename.service;

import org.somename.domain.person.Person;

public interface PersonService {

    public Person getUserByLogin(String userLogin);
    public Person getUserById(String personId);
    public Person createPerson(String userLogin, String firstName, String lastName, String pwEncoded, String type);
    public Person createStudent(String userLogin, String firstName, String lastName, String pwEncoded);
    public Person createFaculty(String userLogin, String firstName, String lastName,String pwEncoded);
    public Person updatePerson(Person person);
    public boolean deletePerson(Person person);


}
