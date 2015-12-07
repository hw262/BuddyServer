/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.service.ProfileService;
import com.sil.buddyserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Han Wang
 */
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody User user) {

        ResponseValue responsevalue = new ResponseValue();

        try {
            userService.create(user);
            profileService.create(user);
        } catch (Exception ex) {
            responsevalue.setResponsevalue(new ErrorCode().UsernameOccupied());
            return ResponseEntity.ok(responsevalue);
        }

        responsevalue.setResponsevalue(new ErrorCode().Success());
        return ResponseEntity.ok(responsevalue);

    }
}
