/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.domain.entity.Hug;
import com.sil.buddyserver.domain.entity.Post;
import com.sil.buddyserver.model.list.ListRequest;
import com.sil.buddyserver.repository.HugRepository;
import com.sil.buddyserver.repository.PostRepository;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Han
 */
@Service
public class HugService {

    @Autowired
    private HugRepository hugRepository;
    
    @Autowired
    private PostRepository postRepository;

    public long countByPidAndUid(long pid, long uid) {
        return hugRepository.countByPidAndUid(pid, uid);
    }

    public int countByPid(long pid) {
        return hugRepository.countByPid(pid);
    }

    public Hug create(long pid, long uid) {
        Date date = Calendar.getInstance().getTime();
        Hug hug = new Hug();
        hug.setDate_time(new Timestamp(date.getTime()));
        hug.setUid(uid);
        Post post = postRepository.findByPid(pid);
        post.setHug(post.getHug()+1);
        return hugRepository.save(hug);
    }

    public List<Hug> findAll(ListRequest listRequest) {
        final PageRequest page1 = new PageRequest(listRequest.getStart(), listRequest.getCount(), Sort.Direction.DESC, "hid");
        Page<Hug> hugPage = hugRepository.findByPid(listRequest.getPid(), page1);
        List<Hug> hugList = hugPage.getContent();
        return hugList;
    }

}
