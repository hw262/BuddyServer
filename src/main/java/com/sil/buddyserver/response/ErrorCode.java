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
public class ErrorCode {
    
    public String Fail(){
        return "0";
    }    
    public String Success(){
        return "1";
    }
      
    public String EmailOccupied(){
        return "100";
    }
    
    public String EmailNotFormat() {
        return "101";
    }
    
    public String VerificationCodeIncorrect() {
        return "102";
    }
      
    public String UsernameOccupied() {
        return "103";
    }

    public String PasswordIncorrect() {
        return "104";
    }
    
    public String UserNotExist() {
        return "105";
    }
    
    public String Test(){
        return "900";
    }    

    public String CantHugYourself() {
        return "106";
    }

}
