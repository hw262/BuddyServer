/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import java.util.List;
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.response.ResponseValue;
import com.sil.buddyserver.domain.entity.Post;
import com.sil.buddyserver.domain.validator.CheckValidator;
import com.sil.buddyserver.model.entity.PostModel;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.service.HugService;
import com.sil.buddyserver.service.PostService;
import com.sil.buddyserver.service.TokenService;
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
public class PostController {

    @Autowired
    private HugService hugService;

    @Autowired
    private PostService postService;

    @Autowired
    private CheckValidator checkValidator;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postcreate(
            @RequestBody Post post,
            @RequestHeader HttpHeaders headers) {

        String username = tokenService.getUserName(headers);

        try {
            postService.create(post, username);
        } catch (Exception ex) {
            return ResponseEntity.ok(new ResponseValue(new ErrorCode().Fail()));
        }
        return ResponseEntity.ok(new ResponseValue(new ErrorCode().Success()));
    }

    @RequestMapping(value = "/post/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postlist(
            @RequestBody ListRequest listRequest,
            @RequestHeader HttpHeaders headers) {

        String username = tokenService.getUserName(headers);
        List<PostModel> postList;

        if (listRequest.getAttention() == 1) {
            postList = postService.findAttention(listRequest);

        } else {
            postList = postService.findAll(listRequest);
        }

        for (int i = 0; i < postList.size(); i++) {

            if (checkValidator.
                    checkIfHugged(postList.get(i).getPid(), username)) {

                postList.get(i).setHuged(1);
            } else {
                postList.get(i).setHuged(0);
            }

            if (checkValidator.
                    checkIfAttentioned(postList.get(i).getPid(), username)) {

                postList.get(i).setAttention(1);
            } else {
                postList.get(i).setAttention(0);
            }

            if (checkValidator.
                    checkIfFlaged(postList.get(i).getPid(), username)) {

                postList.get(i).setFlag(1);
            } else {
                postList.get(i).setFlag(0);
            }

            postList.get(i).
                    setHug(hugService.countByPid(postList.get(i).getPid()));

        }
        return ResponseEntity.ok(postList);
    }

}
