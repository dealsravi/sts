package org.somename.domain.security;

import org.somename.domain.base.BaseDomainObj;

public class User extends BaseDomainObj {

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    private String userLogin;
    private String userType;
    private String idPerson;
    
    @Override
	public String toString() {
		return String.format(
				"User[DB id=%d, userLogin='%s', userType='%s',  idPerson='%s']",
				id, userLogin, userType, idPerson);
	}


}
