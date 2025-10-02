// src/main/java/com/example/weatherapp/controller/WeatherController.java
package com.project.weatherApp.controller;

import com.project.weatherApp.dto.WeatherApiResponse;
import com.project.weatherApp.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherApiResponse getWeather(
            @PathVariable String city,
            @RequestParam(name = "aqi", defaultValue = "false") boolean includeAqi) {
        return weatherService.getCurrentWeather(city, includeAqi);
    }
}
