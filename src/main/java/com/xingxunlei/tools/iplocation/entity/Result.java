package com.xingxunlei.tools.iplocation.entity;

import lombok.Data;

/**
 * 定位结果
 *
 * @author SimonX
 */
@Data
public class Result {

    private String location;
    private String titlecont;
    private String origip;
    private String origipquery;
    private String showlamp;
    private Integer showLikeShare;
    private Integer shareImage;
    private String ExtendedLocation;
    private String OriginQuery;
    private String tplt;
    private String resourceid;
    private String fetchkey;
    private String appinfo;
    private Integer role_id;
    private Integer disp_type;

}
