/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.controller;

import com.sil.buddyserver.domain.entity.Mood;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.repository.MoodRepository;
import com.sil.buddyserver.response.ErrorCode;
import com.sil.buddyserver.response.ResponseValue;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Han Wang
 */
@RestController
public class MoodController {

    @RequestMapping(value = "/mood/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseValue postcreate(@RequestBody Mood mood) {

        ResponseValue responsevalue = new ResponseValue();
        ErrorCode errorcode = new ErrorCode();

        try {
            Date date = new Date();
            mood.setDate_time(new Timestamp(date.getTime()));
            moodRepository.save(mood);
        } catch (Exception ex) {
            responsevalue.setResponsevalue(errorcode.Fail());
            return responsevalue;
        }
        responsevalue.setResponsevalue(errorcode.Success());
        return responsevalue;
    }

    @RequestMapping(value = "/mood/list", method = RequestMethod.POST)
    @ResponseBody
    public Page<Mood> moodlist(@RequestBody ListRequest listrequest) {

        final PageRequest page1 = new PageRequest(listrequest.getStart(), listrequest.getCount(), Sort.Direction.DESC, "mid");
        Page<Mood> moodlist = moodRepository.findByUid(listrequest.getUid(), page1);
        return moodlist;
    }
    @Autowired
    private MoodRepository moodRepository;
}
