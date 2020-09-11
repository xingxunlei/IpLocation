package com.xingxunlei.tools.iplocation.service.impl;

import cn.hutool.core.io.LineHandler;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.xingxunlei.tools.iplocation.entity.Response;
import com.xingxunlei.tools.iplocation.entity.Result;
import com.xingxunlei.tools.iplocation.model.Location;
import com.xingxunlei.tools.iplocation.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 获取 IP 定位信息 Service 接口实现
 *
 * @author SimonX
 */
@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    @Value("${origin.file.path}")
    private String ORIGIN_FILE_PATH;

    @Value("${target.file.path}")
    private String TARGET_FILE_PATH;

    private static final String INTERFACE_URL = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=%s&resource_id=6006";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Result> query(String ip) {
        log.info(String.format("根据 IP[%s] 查询位置信息 service begin...", ip));
        ResponseEntity<Response> responseEntity = restTemplate.getForEntity(String.format(INTERFACE_URL, ip), Response.class);
        log.info(String.format("根据 IP[%s] 查询位置信息 返回结果[%s]", ip, responseEntity.getBody()));
        return responseEntity.getBody().getData();
    }

    @Override
    public boolean getLocations() {
        List<Location> result = new ArrayList<>();
        FileReader reader = new FileReader(ORIGIN_FILE_PATH, Charset.defaultCharset());
        reader.readLines((LineHandler) (s) -> {
            List<String> list = Arrays.asList(s.split(","));
            List<Result> respons = query(list.get(0));
            result.add(Location.builder().ip(list.get(0)).name(list.get(1)).time(list.get(2)).location(respons.get(0).getLocation()).build());
        });

        FileWriter writer = new FileWriter(TARGET_FILE_PATH, Charset.forName("gbk"));
        writer.writeLines(result, true);

        return true;
    }

}
