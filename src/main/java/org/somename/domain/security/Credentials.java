package org.somename.domain.security;

import org.somename.domain.base.BaseDomainObj;

public class Credentials extends BaseDomainObj {
    String userLogin;
    String encodedPw;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getEncodedPw() {
        return encodedPw;
    }

    public void setEncodedPw(String encodedPw) {
        this.encodedPw = encodedPw;
    }

    @Override
	public String toString() {
		return String.format(
				"Credentials[DB id=%d, userLogin='%s', encodedPw='%s']",
				id, userLogin, encodedPw);
	}
    
}
