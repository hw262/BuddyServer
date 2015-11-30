/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.domain.entity.Attention;
import com.sil.buddyserver.domain.entity.Post;

import com.sil.buddyserver.repository.AttentionRepository;
import com.sil.buddyserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Han
 */
@Service
public class AttentionService {

    @Autowired
    private AttentionRepository attentionRepository;
    
    @Autowired
    private PostRepository postRepository;

    public Attention findByPidAndUid(long pid, long uid) {
        return attentionRepository.findByPidAndUid(pid, uid);
    }

    public void cancel(long pid, long uid) {
        Attention attention = attentionRepository.findByPidAndUid(pid, uid);
        attentionRepository.delete(attention.getAid());
        Post post = postRepository.findByPid(pid);
        post.setAttention(post.getAttention() - 1);
        postRepository.save(post);
    }

    public Attention create(long pid, long uid) {
        Attention attention = new Attention();
        attention.setPid(pid);
        attention.setUid(uid);
        Post post = postRepository.findByPid(pid);
        post.setAttention(post.getAttention() + 1);
        postRepository.save(post);
        return attentionRepository.save(attention);
    }

    public long countByPidAndUid(long pid, long uid) {
        return attentionRepository.countByPidAndUid(pid, uid);
    }

}
