package com.wxbc.middle.bean;

import lombok.Data;

/**
 * Created by Zhaochen on 11/7/18
 */
@Data
public class CouQouta {
    private String cbln;
    private String fibln;
    private Integer oldAmount;
    private Integer newAmount;
    private String tradeUuid;
    private Integer size;
}
