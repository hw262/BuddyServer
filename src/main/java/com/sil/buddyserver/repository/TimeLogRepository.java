/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.repository;

import com.sil.buddyserver.domain.entity.TimeLog;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author han
 */
@Transactional
public interface TimeLogRepository extends JpaRepository<TimeLog, Long>{
    
    
}
