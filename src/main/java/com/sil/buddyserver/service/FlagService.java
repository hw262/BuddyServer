/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.domain.entity.Flag;
import com.sil.buddyserver.domain.entity.Post;
import com.sil.buddyserver.repository.FlagRepository;
import com.sil.buddyserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Han
 */
@Service
public class FlagService {

    @Autowired
    private FlagRepository flagRepository;
    
    @Autowired
    private PostRepository postRepository;

    public Flag findByPidAndUid(long pid, long uid) {
        return flagRepository.findByPidAndUid(pid, uid);
    }

    public void cancel(long pid, long uid) {
        Flag flag = flagRepository.findByPidAndUid(pid, uid);
        flagRepository.delete(flag.getFid());
        Post post = postRepository.findByPid(pid);
        post.setFlag(post.getFlag() - 1);
    }

    public void create(long pid, long uid) {
        Flag flag = new Flag();
        flag.setPid(pid);
        flag.setUid(uid);
        Post post = postRepository.findByPid(pid);
        post.setFlag(post.getFlag() + 1);
    }

    public long countByPidAndUid(long pid, long uid) {
        return flagRepository.countByPidAndUid(pid, uid);
    }

}
