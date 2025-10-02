// src/main/java/com/example/weatherapp/service/WeatherService.java
package com.project.weatherApp.service;

import com.project.weatherApp.dto.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weatherapi.key}")
    private String apiKey;

    @Value("${weatherapi.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherApiResponse getCurrentWeather(String city, boolean includeAqi) {
        String url = String.format("%s/current.json?key=%s&q=%s&aqi=%s",
                baseUrl, apiKey, city, includeAqi ? "yes" : "no");

        try {
            return restTemplate.getForObject(url, WeatherApiResponse.class);
        } catch (RestClientException ex) {
            // handle error (like 4xx or 5xx)
            throw new RuntimeException("Error fetching weather data: " + ex.getMessage(), ex);
        }
    }
}
