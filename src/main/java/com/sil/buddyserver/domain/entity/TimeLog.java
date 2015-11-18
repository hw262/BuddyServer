/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.domain.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author han
 */
@Entity
@Table(name = "timelog")
public class TimeLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lid;
    
    private Timestamp date_time;

    public void setLid(long lid) {
        this.lid = lid;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public long getLid() {
        return lid;
    }

    public Timestamp getDate_time() {
        return date_time;
    }
    
    
    
}
