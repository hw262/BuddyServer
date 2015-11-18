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
@Table(name = "flag")
public class Flag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fid;
    
    private long uid;

    private long pid;

    public long getFid() {
        return fid;
    }

    public long getUid() {
        return uid;
    }

    public long getPid() {
        return pid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    
}
