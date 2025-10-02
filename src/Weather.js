import React, { useState } from "react";
import axios from "axios";

function Weather() {
  const [city, setCity] = useState("");
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState(null);

  const fetchWeather = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/weather/${city}`);
      setWeather(response.data);
      setError(null);
    } catch (err) {
      setError("Could not fetch weather data. Try another city.");
      setWeather(null);
    }
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px", fontFamily: "Arial" }}>
      <h1>🌤 Weather App</h1>
      <input
        type="text"
        value={city}
        placeholder="Enter city name"
        onChange={(e) => setCity(e.target.value)}
        style={{ padding: "8px", marginRight: "10px" }}
      />
      <button onClick={fetchWeather} style={{ padding: "8px 16px" }}>
        Get Weather
      </button>

      {error && <p style={{ color: "red" }}>{error}</p>}

      {weather && (
        <div style={{ marginTop: "20px" }}>
          <h2>{weather.location?.name}, {weather.location?.country}</h2>
          <p><strong>Temperature:</strong> {weather.current?.temp_c} °C</p>
          <p><strong>Condition:</strong> {weather.current?.condition?.text}</p>
          <img src={weather.current?.condition?.icon} alt="weather icon" />
          <p><strong>Humidity:</strong> {weather.current?.humidity}%</p>
          <p><strong>Wind:</strong> {weather.current?.wind_kph} kph</p>
        </div>
      )}
    </div>
  );
}

export default Weather;
