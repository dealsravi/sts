package org.somename.domain.base;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.somename.domain.course.Course;

@Entity
public class BaseDomainObj  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomainObj baseObj = (BaseDomainObj) o;
        return id==baseObj.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
