// src/main/java/com/example/weatherapp/dto/WeatherApiResponse.java
package com.project.weatherApp.dto;

import lombok.Data;

@Data
public class WeatherApiResponse {
    private Location location;
    private CurrentWeather current;
}
