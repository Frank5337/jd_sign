package com.zbl.service;

import com.zbl.component.TaskApplication;
import com.zbl.model.UcCookie;
import com.zbl.pojo.ReturnParamPojo;
import com.zbl.tools.MailTool;
import com.zbl.util.RedisUtil;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @功能:
 * @项目名:jdcheckin
 * @作者:0cm
 * @日期:2020/4/72:51 下午
 */
@Service
public class StartCheckIn {
    private final static Logger logger = LoggerFactory.getLogger(TaskApplication.class);
    @Autowired
    private CheckIn checkIn;
    @Autowired
    private MailTool mailTool;
    @Autowired
    private RedisUtil redisUtil;

    private static int times = 0;

    private static int threshold = 4;

    @Autowired
    private UcCookieService ucCookieService;

    public String startCheckIn() throws JSONException, UnsupportedEncodingException, InterruptedException {
        StringBuilder finalNotify = new StringBuilder();
        for (UcCookie ucCookie : ucCookieService.findAll()) {
            checkIn.cookie = ucCookie.getCookie();

            List<ReturnParamPojo> list = new ArrayList<>();
            list.add(checkIn.JingDongBean());//京东京豆
            list.add(checkIn.JingRongBean());//金融京豆
            list.add(checkIn.JingRongSteel());//京东钢镚
            list.add(checkIn.JingDongTurn(new ReturnParamPojo()));//京东转盘
            //list.add(checkIn.JingRSeeAds());//京东金融-广告 无接口调用权限
            list.add(checkIn.JDGroceryStore());//京东超市
            list.add(checkIn.JingDongClocks());//京东钟表馆
            list.add(checkIn.JingDongPet());//京豆宠物
            list.add(checkIn.JDFlashSale());//京东闪购
            list.add(checkIn.JDSecondhand());//京东拍拍二手
            list.add(checkIn.JingDongBook());//京东图书
            list.add(checkIn.JingDMakeup());//京东美妆管
            list.add(checkIn.JingDongWomen());//京东女装馆
            list.add(checkIn.JingDongCash());//京东现金红包
            list.add(checkIn.JingDongShoes());//京东鞋靴
            list.add(checkIn.JingDongFood());//京东美食
            list.add(checkIn.JingRongGame());//金融游戏大厅
            list.add(checkIn.JingDongLive());//京东智能生活馆
            list.add(checkIn.JingDongClean());//京东清洁管
            list.add(checkIn.JDPersonalCare());//京东个人护理

            list.add(checkIn.JingDongPrize());//京东大奖签到
            list.add(checkIn.JingDongShake(new ReturnParamPojo()));//京东摇一摇


            Integer success = 0;
            Integer fail = 0;
            StringBuffer notify = new StringBuffer();
            for (ReturnParamPojo pojo : list) {
                if (null != pojo.getSuccess() && pojo.getSuccess() > 0) {
                    success += pojo.getSuccess();
                }
                if (null != pojo.getFail() && pojo.getFail() > 0) {
                    fail += pojo.getFail();
                }
                notify.append("<br>\n" + pojo.getNotify());
            }

            finalNotify.append("<br>\n【签到概括】：成功：" + success + "失败：" + fail)
                    .append("<br>\n【账号总计】：" + checkIn.TotalBean() + "京豆," + checkIn.TotalSteel() + "钢镚," + checkIn.TotalCash() + "红包")
                    .append("【账号】: " + ucCookie.getUserName())
                    .append(notify)
                    .append("<br>\n" + new Date().getDate()).append("/").append(new Date().getHours())
                    .append("\n" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.info(finalNotify.toString());
            //发送邮件
            //mailTool.sendSimpleMail(finalNotify.toString());
            //计数器
//        times++;
//        if (times > threshold) {
//            times = 0;
//        }
//        key+=times;
            finalNotify.append("<br>\n");
        }

        String key = String.valueOf(new Date().getDate() + new Date().getHours());
        redisUtil.set(key, finalNotify.toString(), 60 * 60 * 24 * 2);

        return finalNotify.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Date().getDate() + new Date().getHours());
    }
}