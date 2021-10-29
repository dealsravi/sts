package org.somename.data;

import org.somename.domain.base.BaseDomainObj;
import org.springframework.data.repository.CrudRepository;

public  interface  BaseRepository<BaseDomainObj, Long> extends CrudRepository<BaseDomainObj, Long> {

}
