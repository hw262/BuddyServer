/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.model.list;

/**
 *
 * @author Han Wang
 */
public class ListRequest {

    private int start;

    private int count;

    private long uid;

    private long pid;

    private int attention;

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public long getUid() {
        return uid;
    }

    public long getPid() {
        return pid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
