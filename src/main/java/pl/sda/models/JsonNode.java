package pl.sda.models;

import java.util.List;

public class JsonNode {
    private Coord coord;
    private Weather weather;

    public JsonNode() {
    }

    public JsonNode(Coord coord,Weather weather) {
        this.coord = coord;
        this.weather = weather;
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

    @Override
    public String toString() {
        return "JsonNode{" +
                "coord=" + coord +
                ", weather=" + weather +
                '}';
    }
}
