package pl.sda.models;

import jakarta.persistence.*;

@Entity
public class Weather {

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

    @Column(name = "service")
    private String service;

    public int getWeatherId() {
        return weatherId;
    }

    public Weather(int weatherId, City cityId, double temperature, double pressure, double humidity, double windDeg, double windSpeed, String service) {
        this.weatherId = weatherId;
        this.cityId = cityId;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windDeg = windDeg;
        this.windSpeed = windSpeed;
        this.service = service;
    }

    public Weather() {
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(double windDeg) {
        this.windDeg = windDeg;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherId=" + weatherId +
                ", cityId=" + cityId +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windDeg=" + windDeg +
                ", windSpeed=" + windSpeed +
                ", service='" + service + '\'' +
                '}';
    }
}