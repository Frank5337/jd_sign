package com.zbl.pojo;

import lombok.Data;

/**
 * @功能:
 * @项目名:jdcheckin
 * @作者:0cm
 * @日期:2020/4/13:44 下午
 */
@Data
public class ResultData {
    private ResponseData data;
    private ResBusiData resBusiData;
    private Integer code;
    private Boolean canGetGb;
    private Integer volumn;
}