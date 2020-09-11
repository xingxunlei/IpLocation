package com.xingxunlei.tools.iplocation.model;

import lombok.Builder;
import lombok.Data;

/**
 * Model 层的响应结果
 *
 * @author SimonX
 */
@Data
@Builder
public class Location {

    private String ip;
    private String name;
    private String time;
    private String location;

    @Override
    public String toString() {
        return ip + "," + name + "," + time + "," + location;
    }
}
