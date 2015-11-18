/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.repository;

import com.sil.buddyserver.domain.entity.Mood;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Han Wang
 */
@Transactional
public interface MoodRepository extends JpaRepository<Mood, Long> {

    public Mood findByUid(String uid);

    public Page<Mood> findByUid(long uid, Pageable pageable);
    
    
}