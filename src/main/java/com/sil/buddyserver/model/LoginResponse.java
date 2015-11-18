/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.model;

/**
 *
 * @author Han
 */
public class LoginResponse {

    private String responsevalue;
    private String token;

    public String getResponsevalue() {
        return responsevalue;
    }

    public String getToken() {
        return token;
    }

    public void setResponsevalue(String responsevalue) {
        this.responsevalue = responsevalue;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
