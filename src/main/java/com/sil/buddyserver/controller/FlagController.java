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
import com.sil.buddyserver.security.TokenUtils;
import com.sil.buddyserver.service.FlagService;
import com.sil.buddyserver.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
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
public class FlagController {

    @Autowired
    private UserService userService;

    @Autowired
    private FlagService flagService;

    @Autowired
    private CheckValidator checkValidator;

    @Value("${buddyserver.token.header}")
    private String tokenHeader;

    @RequestMapping(value = "/flag", method = RequestMethod.POST)
    @ResponseBody
    public ResponseValue flag(@RequestBody ListRequest listRequest, @RequestHeader HttpHeaders headers) {

        ResponseValue responsevalue = new ResponseValue();

        List<String> token = headers.get(tokenHeader);
        String username = TokenUtils.getUsernameFromToken(token.get(0));
        User user = userService.findUserByUsername(username);

        if (checkValidator.checkIfFlaged(listRequest.getPid(), username)) {

            flagService.cancel(listRequest.getPid(), user.getId());

        } else {
            flagService.create(listRequest.getPid(), user.getId());
        }

        responsevalue.setResponsevalue(new ErrorCode().Success());
        return responsevalue;
    }

}
