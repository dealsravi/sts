package org.somename.data;

import java.util.List;

import org.somename.domain.person.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends BaseRepository<Person, Long> {

	List<Person> findByLastName(String lastName);

	Person findById(String id);
}

