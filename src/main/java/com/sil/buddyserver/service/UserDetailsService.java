/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.model.security.CurrentUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Han
 */
public interface UserDetailsService {

    public CurrentUser loadUserByUsername(String string) throws UsernameNotFoundException;
}
