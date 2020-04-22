package com.zbl;

import com.foreign.JdcheckinApplication;
import com.foreign.tools.MailTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: zbl
 * @Date: Created in 10:17 2019/8/23
 * @Description: 测试用
 * @Version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JdcheckinApplication.class)
public class MailServiceTest {

    @Resource
    private MailTool mailService;

    @Test
    public void test01() throws Exception {
        String to = "877910220@qq.com";
        String subject = "测试邮件";
        String content = "hello this is simple mail";
        mailService.sendSimpleMail("123");
    }


}
