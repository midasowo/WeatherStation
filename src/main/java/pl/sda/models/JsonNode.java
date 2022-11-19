package pl.sda.models;

public class JsonNode {
    private Coord coord;
    private Weather weather;
    private City city;

    public JsonNode() {
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
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
                "coord=" + coord +
                ", weather=" + weather +
                ", city=" + city +
                '}';
    }
}
