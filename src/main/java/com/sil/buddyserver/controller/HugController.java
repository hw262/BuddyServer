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
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.service.HugService;
import com.sil.buddyserver.service.PostService;
import com.sil.buddyserver.service.TokenService;
import com.sil.buddyserver.service.UserService;
import java.util.List;
import java.util.Objects;
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
public class HugController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private HugService hugService;

    @Autowired
    private CheckValidator checkValidator;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/hug", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> hug(
            @RequestBody ListRequest listRequest,
            @RequestHeader HttpHeaders headers) {

        String username = tokenService.getUserName(headers);

        User currentUser = userService.findUserByUsername(username);

        try {

            Post post = postService.findPostById(listRequest.getPid());

            if (!Objects.equals(post.getUid(), currentUser.getId())) {

                if (!checkValidator.checkIfHugged(listRequest.getPid(), username)) {

                    hugService.create(listRequest.getPid(), currentUser.getId());

                } else {
                    hugService.cancel(listRequest.getPid(), currentUser.getId());
                }
            } else {

                return ResponseEntity.ok(new ResponseValue(new ErrorCode().CantHugYourself()));

            }
        } catch (Exception ex) {

            return ResponseEntity.ok(new ResponseValue(new ErrorCode().Fail()));
        }
        return ResponseEntity.ok(new ResponseValue(new ErrorCode().Success()));
    }

    @RequestMapping(value = "/hug/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> huglist(
            @RequestBody ListRequest listRequest,
            @RequestHeader HttpHeaders headers) {

        String username = tokenService.getUserName(headers);
        
        User currentUser = userService.findUserByUsername(username);
        Post post = postService.findPostById(listRequest.getPid());
        
        if (Objects.equals(post.getUid(), currentUser.getId())) {
            List<Hug> hugList = hugService.findAll(listRequest);
            return ResponseEntity.ok(hugList);
        }
        
        return ResponseEntity.ok(new ResponseValue(new ErrorCode().Fail()));
    }

}
