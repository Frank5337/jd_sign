package com.zbl.pojo;

import lombok.Data;

/**
 * @功能:
 * @项目名:jdcheckin
 * @作者:0cm
 * @日期:2020/4/22:22 下午
 */
@Data
public class BusinessData {
    private BusinessData businessData;
    private AwardListVo[] awardListVo;
    private String businessCode;
    private String businessMsg;
}