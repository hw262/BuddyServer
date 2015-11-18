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
 * @author Han Wang
 */
@Entity
@Table(name = "hug")
public class Hug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hid;

    private long uid;

    private long pid;

    private int hug_back;

    private Timestamp date_time;

    private String username;

    public long getHid() {
        return hid;
    }

    public long getUid() {
        return uid;
    }

    public long getPid() {
        return pid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHug_back() {
        return hug_back;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setHug_back(int hug_back) {
        this.hug_back = hug_back;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

}
