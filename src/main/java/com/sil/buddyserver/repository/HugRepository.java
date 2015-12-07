/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.repository;

import com.sil.buddyserver.domain.entity.Hug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Han Wang
 */
public interface HugRepository extends JpaRepository<Hug, Long>{

    public long countByPidAndUid(long pid, long uid);
    
    public int countByPid(long pid);

    public Page<Hug> findByPid(long pid, Pageable pageable);

    public Hug findByPidAndUid(long pid, long id);

}
