/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import com.sil.buddyserver.domain.entity.Hug;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.domain.entity.Post;
import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.domain.validator.CheckValidator;
import com.sil.buddyserver.model.security.CurrentUser;
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.security.TokenUtils;
import com.sil.buddyserver.service.HugService;
import com.sil.buddyserver.service.PostService;
import com.sil.buddyserver.service.UserDetailsServiceImpl;
import com.sil.buddyserver.service.UserService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
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
public class HugController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private HugService hugService;

    @Autowired
    private CheckValidator checkValidator;
    

    @Value("${buddyserver.token.header}")
    private String tokenHeader;

    @RequestMapping(value = "/hug", method = RequestMethod.POST)
    @ResponseBody
    public ResponseValue hug(@RequestBody ListRequest listRequest, @RequestHeader HttpHeaders headers) {

        ResponseValue responsevalue = new ResponseValue();
        List<String> token = headers.get(tokenHeader);
        String username = TokenUtils.getUsernameFromToken(token.get(0));
        User currentUser = userService.findUserByUsername(username);

        try {
            Post post = postService.findPostById(listRequest.getPid());

            if (!Objects.equals(post.getUid(), currentUser.getId())) {

                if (!checkValidator.checkIfHugged(listRequest.getPid(), username)) {
                    
                    hugService.create(listRequest.getPid(), currentUser.getId());
                    
                } else {

                    responsevalue.setResponsevalue(new ErrorCode().Fail());
                    return responsevalue;

                }
            } else {

                responsevalue.setResponsevalue(new ErrorCode().CantHugYourself());
                return responsevalue;

            }
        } catch (Exception ex) {
            responsevalue.setResponsevalue(new ErrorCode().Fail());
            return responsevalue;
        }
        responsevalue.setResponsevalue(new ErrorCode().Success());
        return responsevalue;
    }

    @RequestMapping(value = "/hug/list", method = RequestMethod.POST)
    @ResponseBody
    public List<Hug> huglist(@RequestBody ListRequest listrequest
    ) {

        List<Hug> hugList = hugService.findAll(listrequest);
        return hugList;
    }

}
