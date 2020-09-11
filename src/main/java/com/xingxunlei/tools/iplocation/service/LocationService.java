package com.xingxunlei.tools.iplocation.service;

import com.xingxunlei.tools.iplocation.entity.Result;

import java.util.List;

/**
 * 获取 IP 定位信息 Service 接口
 *
 * @author SimonX
 */
public interface LocationService {

    List<Result> query(String ip);

    boolean getLocations();

}
