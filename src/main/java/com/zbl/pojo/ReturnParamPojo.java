package com.zbl.pojo;

import lombok.Data;

/**
 * @功能:
 * @项目名:jdcheckin
 * @作者:0cm
 * @日期:2020/3/3110:03 上午
 */
@Data
public class ReturnParamPojo {
    //成功返回个数
    private Integer success;
    //失败返回个数
    private Integer fail;
    //京豆
    private Integer bean;
    //钢镚
    private Double steel;
    //红包
    private Double cash;
    //
    private String notify;


}