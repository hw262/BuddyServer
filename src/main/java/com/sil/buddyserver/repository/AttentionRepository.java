/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.repository;

import com.sil.buddyserver.domain.entity.Attention;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Han
 */
public interface AttentionRepository extends JpaRepository<Attention, Long> {

    public long countByPidAndUid(long pid, long uid);

    public Attention findByPidAndUid(long pid, Long id);

}
