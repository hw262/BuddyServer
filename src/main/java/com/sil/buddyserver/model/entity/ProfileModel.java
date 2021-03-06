/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.model.entity;

import com.sil.buddyserver.domain.entity.Profile;

/**
 *
 * @author Han
 */
public class ProfileModel {


    private String username;

    private int avatar;

    private String personal_intro;

    private String birth_date;

    private String gender;

    private int race;

    private String sexuality;

    public ProfileModel(Profile profile) {

        this.setPersonal_intro(profile.getPersonal_intro());
        this.setAvatar(profile.getAvatar());
        if (profile.getBirth_date_auth() == 1) {
            this.setBirth_date(profile.getBirth_date());
        }
        if (profile.getGender_auth() == 1) {
            this.setGender(profile.getGender());
        }
        if (profile.getRace_auth() == 1) {
            this.setRace(profile.getRace());
        }
        if (profile.getSexuality_auth() == 1) {
            this.setSexuality(profile.getSexuality());
        }
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getUsername() {
        return username;
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
    

}
