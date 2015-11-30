/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.domain.validator;

import com.sil.buddyserver.service.AttentionService;
import com.sil.buddyserver.service.FlagService;
import com.sil.buddyserver.service.HugService;
import com.sil.buddyserver.service.UserService;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Han
 */
@Service
public class CheckValidator {

    @Autowired
    private HugService hugService;

    @Autowired
    private UserService userService;

    @Autowired
    private AttentionService attentionService;

    @Autowired
    private FlagService flagService;

    public boolean checkIfHugged(long pid, String username) {
        long uid = userService.findUserByUsername(username).getId();
        long exist = hugService.countByPidAndUid(pid, uid);
        if (exist > 0) {
            return TRUE;
        }
        return FALSE;
    }

    public boolean checkIfAttentioned(long pid, String username) {
        long uid = userService.findUserByUsername(username).getId();
        long exist = attentionService.countByPidAndUid(pid, uid);
        if (exist > 0) {
            return TRUE;
        }
        return FALSE;
    }

    public boolean checkIfFlaged(long pid, String username) {
        long uid = userService.findUserByUsername(username).getId();
        long exist = flagService.countByPidAndUid(pid, uid);
        if (exist > 0) {
            return TRUE;
        }
        return FALSE;
    }

}
