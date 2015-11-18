/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Han
 */
@Entity
@Table(name = "attention")
public class Attention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aid;

    private long uid;

    private long pid;

    public long getAid() {
        return aid;
    }

    public long getUid() {
        return uid;
    }

    public long getPid() {
        return pid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }    
}
