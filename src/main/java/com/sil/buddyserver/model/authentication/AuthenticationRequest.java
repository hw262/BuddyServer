package com.sil.buddyserver.model.authentication;

import com.sil.buddyserver.model.ModelBase;

public class AuthenticationRequest extends ModelBase {

    private static final long serialVersionUID = 6624726180748515507L;
    private String email;
    private String password;

    public AuthenticationRequest() {
        super();
    }

    public AuthenticationRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
