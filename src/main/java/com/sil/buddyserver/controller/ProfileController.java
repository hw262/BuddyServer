/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import com.sil.buddyserver.domain.entity.Profile;
import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.model.ProfileModel;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.repository.ProfileRepository;
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.security.TokenUtils;
import com.sil.buddyserver.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${buddyserver.token.header}")
    private String tokenHeader;

    @Autowired
    private UserService userService;
    
    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> editProfile(@RequestBody Profile profile, @RequestHeader HttpHeaders headers) {

        List<String> token = headers.get(tokenHeader);
        String username = TokenUtils.getUsernameFromToken(token.get(0));

        try {
            User user = userService.findUserByUsername(username);
            profile.setUid(user.getId());
            profileRepository.save(profile);
        } catch (Exception ex) {
            return ResponseEntity.ok(new ResponseValue(new ErrorCode().Fail()));
        }

        return ResponseEntity.ok(new ResponseValue(new ErrorCode().Success()));
    }

    @RequestMapping(value = "/profile/view", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> viewProfile(@RequestBody ListRequest listRequest, @RequestHeader HttpHeaders headers) {

        List<String> token = headers.get(tokenHeader);
        String username = TokenUtils.getUsernameFromToken(token.get(0));
        long uid = listRequest.getUid();
        Profile profile;
        try {
            if (uid == 0) {
                User user = userService.findUserByUsername(username);
                uid = user.getId();
            }
            profile = profileRepository.findByUid(uid);
        } catch (Exception ex) {
            return ResponseEntity.ok(new ResponseValue(new ErrorCode().UserNotExist()));
        }
        return ResponseEntity.ok(new ProfileModel(profile));
    }
}
