/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.repository;

import com.sil.buddyserver.domain.entity.Post;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Han Wang
 */
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {

    public Post findByPid(long pid);

    public Page<Post> findAll(Pageable pageable);
    
    public Page<Post> findByAttentionGreaterThan(int attention, Pageable pageable);

    public Post findPostByUsername(String username);
    
}