/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.domain.entity.Profile;
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
    
    public Profile create(){
        Profile profile = new Profile();
        SimpleDateFormat birthDate = new SimpleDateFormat("yyyy-MM-dd"); 
        profile.setBirth_date(birthDate.format(1980-01-01));
        return profileRepository.save(profile);
    }
            
}
