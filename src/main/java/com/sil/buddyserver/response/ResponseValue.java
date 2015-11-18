/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.response;

/**
 *
 * @author Han Wang
 */
public class ResponseValue {
    
    private String responsevalue;
    
    public ResponseValue(){
        
    }
    
    public ResponseValue(String responsevalue) {
        this.setResponsevalue(responsevalue);
    }
    
    public void setResponsevalue(String responsevalue) {
        this.responsevalue = responsevalue;
    }

    public String getResponsevalue() {
        return responsevalue;
    }
}
