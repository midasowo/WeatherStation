package pl.sda.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class WeatherAvg {

    @Column(name = "weather_id")
    private int weatherId;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City cityId;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "pressure")
    private double pressure;

    @Column(name = "humidity")
    private double humidity;

    @Column(name = "wind_deg")
    private double windDeg;

    @Column(name = "wind_speed")
    private double windSpeed;
}
