package com.zbl.component;

import com.zbl.service.CheckIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:foreign
 * Date:2020/4/7
 * Time:17:30
 */
@Component
public class TaskApplication implements ApplicationRunner {

    private final static Logger logger = LoggerFactory.getLogger(TaskApplication.class);

    @Autowired
    private CheckIn checkIn;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
