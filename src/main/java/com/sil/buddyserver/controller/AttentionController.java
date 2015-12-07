/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.domain.validator.CheckValidator;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.service.AttentionService;
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
public class AttentionController {

    @Autowired
    private UserService userService;

    @Autowired
    private CheckValidator checkValidator;

    @Autowired
    private AttentionService attentionService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/bell", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> attention(
            @RequestBody ListRequest listRequest, 
            @RequestHeader HttpHeaders headers) {

        String username = tokenService.getUserName(headers);

        User user = userService.findUserByUsername(username);

        if (checkValidator.checkIfAttentioned(listRequest.getPid(), username)) {

            attentionService.cancel(listRequest.getPid(), user.getId());

        } else {
            attentionService.create(listRequest.getPid(), user.getId());
        }

        return ResponseEntity.ok(new ResponseValue(new ErrorCode().Success()));
    }

}
