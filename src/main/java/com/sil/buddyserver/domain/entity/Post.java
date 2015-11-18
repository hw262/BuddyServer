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
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;

    private Long uid;

    private int category;

    private String content;

    private int flag;

    private int attention;

    private Timestamp date_time;

    private String username;

    private int hug;

    private int huged;

    public long getPid() {
        return pid;
    }

    public Long getUid() {
        return uid;
    }

    public int getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public int getFlag() {
        return flag;
    }

    public int getAttention() {
        return attention;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public String getUsername() {
        return username;
    }

    public int getHug() {
        return hug;
    }

    public int getHuged() {
        return huged;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHug(int hug) {
        this.hug = hug;
    }

    public void setHuged(int huged) {
        this.huged = huged;
    }

}
