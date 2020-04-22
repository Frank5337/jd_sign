package com.foreign.task;

import com.foreign.service.StartCheckIn;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import java.io.UnsupportedEncodingException;

/**
 * @功能:定时任务
 * @项目名:jdcheckin
 * @作者:0cm
 * @日期:2020/3/303:20 下午
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
public class ScheduleTask {
    @Autowired
    private StartCheckIn startCheckIn;
    //3.添加定时任务
    @Scheduled(cron = "${cron}")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() throws InterruptedException, UnsupportedEncodingException, JSONException {
        startCheckIn.startCheckIn();
    }
}