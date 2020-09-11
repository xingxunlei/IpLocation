package com.xingxunlei.tools.iplocation.resource;

import com.xingxunlei.tools.iplocation.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取地址
 *
 * @author SimonX
 */
@Slf4j
@RestController
public class LocationResource {

    @Autowired
    private LocationService locationService;

    @GetMapping("/ip/{ip}")
    public Object getLocation(@PathVariable("ip") String ip) {
        log.info(String.format("根据 IP[%s] 查询位置信息 resource begin...", ip));
        return locationService.query(ip);
    }

    @GetMapping("/ip/start")
    public Object getLocations() {
        return locationService.getLocations();
    }

}
