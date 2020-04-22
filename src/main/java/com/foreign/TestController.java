package com.foreign;

import com.foreign.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

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

}
