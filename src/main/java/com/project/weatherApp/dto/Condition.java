// src/main/java/com/example/weatherapp/dto/Condition.java
package com.project.weatherApp.dto;

import lombok.Data;

@Data
public class Condition {
    private String text;
    private String icon;
    private int code;
}
