package com.xingxunlei.tools.iplocation.entity;

import lombok.Data;

import java.util.List;

/**
 * IP 定位接口返回结果
 *
 * @author SimonX
 */
@Data
public class Response {

    private String status;
    private String t;
    private String set_cache_time;
    private List<Result> data;

}
