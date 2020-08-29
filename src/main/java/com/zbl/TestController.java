package com.zbl;

import com.zbl.service.StartCheckIn;
import com.zbl.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

/**
 * Created with IDEA
 * author:foreign
 * Date:2020/4/7
 * Time:18:20
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private StartCheckIn startCheckIn;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "jd 测试";
    }

    @RequestMapping("/getMsg/{date}")
    @ResponseBody
    public String today(@PathVariable("date") String date){
        log.info("-------getMsg-------");
        return (String) redisUtil.get(date);
    }

    @RequestMapping("/run")
    @ResponseBody
    public String run() throws InterruptedException, UnsupportedEncodingException, JSONException {
        return startCheckIn.startCheckIn();
    }

}
