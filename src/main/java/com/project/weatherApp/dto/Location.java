// src/main/java/com/example/weatherapp/dto/Location.java
package com.project.weatherApp.dto;

import lombok.Data;

@Data
public class Location {
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private long localtime_epoch;
    private String localtime;
}
