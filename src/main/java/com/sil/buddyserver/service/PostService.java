/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.domain.entity.Post;
import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.model.entity.PostModel;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.repository.PostRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Han
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public List<PostModel> findAll(ListRequest listRequest) {
        final PageRequest page1 = new PageRequest(
                listRequest.getStart(), 
                listRequest.getCount(), 
                Sort.Direction.DESC, 
                "pid");
        
        Page<Post> pPage = postRepository.findAll(page1);
        List<Post> pList = pPage.getContent();
        ArrayList postList = new ArrayList();
        
        for (int i = 0; i < pList.size(); i++) {
            postList.add(i, new PostModel(pList.get(i)));
        }

        return postList;
    }

    public Post create(Post post, String username) {
        Date date = new Date();
        post.setDate_time(new Timestamp(date.getTime()));
        post.setUsername(username);
        User user = userService.findUserByUsername(username);
        post.setUid(user.getId());
        return postRepository.save(post);
    }

    public Post findPostById(Long id) {
        return postRepository.findOne(id);
    }

    public Post update(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.delete(id);
    }

    public Post findPostByUsername(String username) {
        return postRepository.findPostByUsername(username);
    }

    public List<PostModel> findAttention(ListRequest listRequest) {
        final PageRequest page1 = new PageRequest(
                listRequest.getStart(), 
                listRequest.getCount(), 
                Sort.Direction.DESC, 
                "pid");
        
        Page<Post> pPage = postRepository.findByAttentionGreaterThan(1, page1);
        List<Post> pList = pPage.getContent();
        ArrayList postList = new ArrayList();
        for (int i = 0; i < pList.size(); i++) {
            System.out.println(pList.get(i).toString());
            postList.add(i, new PostModel(pList.get(i)));
        }

        return postList;
    }

}
