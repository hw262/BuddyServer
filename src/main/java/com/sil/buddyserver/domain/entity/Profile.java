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
 * @author Han Wang
 */
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private int avatar;

    private String personal_intro;

    private String birth_date;

    private String gender;

    private int race;

    private String sexuality;

    private int birth_date_auth;

    private int gender_auth;

    private int race_auth;

    private int sexuality_auth;

    public long getUid() {
        return uid;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getPersonal_intro() {
        return personal_intro;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getGender() {
        return gender;
    }

    public int getRace() {
        return race;
    }

    public String getSexuality() {
        return sexuality;
    }

    public int getBirth_date_auth() {
        return birth_date_auth;
    }

    public int getGender_auth() {
        return gender_auth;
    }

    public int getRace_auth() {
        return race_auth;
    }

    public int getSexuality_auth() {
        return sexuality_auth;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setPersonal_intro(String personal_intro) {
        this.personal_intro = personal_intro;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }

    public void setBirth_date_auth(int birth_date_auth) {
        this.birth_date_auth = birth_date_auth;
    }

    public void setGender_auth(int gender_auth) {
        this.gender_auth = gender_auth;
    }

    public void setRace_auth(int race_auth) {
        this.race_auth = race_auth;
    }

    public void setSexuality_auth(int sexuality_auth) {
        this.sexuality_auth = sexuality_auth;
    }

}
