/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.task;

import com.sil.buddyserver.domain.entity.TimeLog;
import com.sil.buddyserver.repository.TimeLogRepository;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author han
 */
@Component
public class MysqlConnectTask {
    @Autowired
    private TimeLogRepository timeLogRepository;
    
    @Scheduled(fixedRate = 7200000)
    public void currenttime(){
        Date date = Calendar.getInstance().getTime();
        TimeLog timeLog = new TimeLog();
        timeLog.setDate_time(new Timestamp(date.getTime()));
        timeLogRepository.save(timeLog);
        System.out.println("Now the time is: " + date);
    }
    
}
