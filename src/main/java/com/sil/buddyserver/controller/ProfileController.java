/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import com.sil.buddyserver.domain.entity.Profile;
import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.model.entity.ProfileModel;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.service.ProfileService;
import com.sil.buddyserver.service.TokenService;
import com.sil.buddyserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Han Wang
 */
@RestController
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> editProfile(@RequestBody Profile profile, @RequestHeader HttpHeaders headers) {

        String username = tokenService.getUserName(headers);

        try {
            User currentUser = userService.findUserByUsername(username);
            profile.setUid(currentUser.getId());
            profileService.save(profile);
        } catch (Exception ex) {
            return ResponseEntity.ok(new ResponseValue(new ErrorCode().Fail()));
        }

        return ResponseEntity.ok(new ResponseValue(new ErrorCode().Success()));
    }

    @RequestMapping(value = "/profile/view", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> viewProfile(@RequestBody ListRequest listRequest, @RequestHeader HttpHeaders headers) {

        String username = tokenService.getUserName(headers);
        Long uid = listRequest.getUid();
        ProfileModel profile;
        try {
            if (uid == 0) {
                User currentUser = userService.findUserByUsername(username);
                uid = currentUser.getId();
            }
            profile = profileService.findByUid(uid);
            profile.setUsername(username);
            
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
        }
        return ResponseEntity.ok(profile);
    }
}
