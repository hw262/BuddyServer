/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import com.sil.buddyserver.domain.entity.Profile;
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.repository.ProfileRepository;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private ProfileRepository profileRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseValue register(@RequestBody User user) {

        ResponseValue responsevalue = new ResponseValue();

        try {
            String password = user.getPassword();
            user.setPassword(passwordEncoder().encode(password));
            user.setAuthorities("USER");
            userService.create(user);
            Profile profile = new Profile();
            profileRepository.save(profile);
        } catch (Exception ex) {
            responsevalue.setResponsevalue(new ErrorCode().UsernameOccupied());
            return responsevalue;
        }

        responsevalue.setResponsevalue(new ErrorCode().Success());
        return responsevalue;

    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
