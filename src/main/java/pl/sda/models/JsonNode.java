package pl.sda.models;

public class JsonNode {
    private Weather weather;
    private City city;

    public JsonNode() {
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "JsonNode{" +
                "weather=" + weather +
                ", city=" + city +
                '}';
    }
}
