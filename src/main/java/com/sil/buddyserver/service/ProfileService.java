/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.domain.entity.Profile;
import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.model.entity.ProfileModel;
import com.sil.buddyserver.repository.ProfileRepository;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author han
 */
@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile create(User user) {
        Profile profile = new Profile();
        profile.setUid(user.getId());
        SimpleDateFormat birthDate = new SimpleDateFormat("yyyy-MM-dd");
        profile.setBirth_date(birthDate.format(1980-01-01));
        profile.setGender("0");
        profile.setPersonal_intro("0");
        profile.setSexuality("0");
        profile.setBirth_date_auth(1);
        profile.setGender_auth(1);
        profile.setRace_auth(1);
        profile.setSexuality_auth(1);
        return profileRepository.save(profile);
    }

    public ProfileModel findByUid(long uid) {
        Profile profile = profileRepository.findByUid(uid);
        ProfileModel profileModel = new ProfileModel(profile);
        return profileModel;
    }

}
