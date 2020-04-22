package com.foreign.pojo;

import lombok.Data;

/**
 * @功能:
 * @项目名:jdcheckin
 * @作者:0cm
 * @日期:2020/4/111:29 上午
 */
@Data
public class ResponseData {
    private Integer status;
    private DailyAward dailyAward;
    private ContinuityAward continuityAward;
    private Integer rewardAmount;
    private Integer prizeSendNumber;
    private Integer chances;
    private BusinessData businessData;
    private Integer volumn;
    private FloorInfo[] floorInfoList;
    private Boolean canGetGb;
    private Integer beanNumber;
    private CouponInfoVo couponInfoVo;
    private Integer pitType;
    private PrizeBean prizeBean;
    private PrizeCoupon prizeCoupon;
    private LuckyBox luckyBox;
}