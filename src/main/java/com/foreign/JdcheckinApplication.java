package com.foreign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启定时
public class JdcheckinApplication {
    private static Logger logger = LoggerFactory.getLogger(JdcheckinApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JdcheckinApplication.class, args);
    }
}