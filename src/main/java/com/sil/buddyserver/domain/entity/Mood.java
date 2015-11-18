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
@Table(name = "mood")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mid;

    private int mood;

    private long uid;

    private Timestamp date_time;

    public void setMid(long mid) {
        this.mid = mid;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public long getMid() {
        return mid;
    }

    public int getMood() {
        return mood;
    }

    public long getUid() {
        return uid;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

}
