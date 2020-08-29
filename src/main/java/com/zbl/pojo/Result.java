package com.zbl.pojo;

import lombok.Data;

/**
 * @功能:
 * @项目名:jdcheckin
 * @作者:0cm
 * @日期:2020/4/311:43 上午
 */
@Data
public class Result {
    private Integer code;
    private Integer count;
    private SignResult signResult;
}