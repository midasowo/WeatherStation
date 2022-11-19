package pl.sda.models;

import jakarta.persistence.*;

@Entity
@Table(name = "weatheravg")
public class WeatherAvg {

    @Id
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
