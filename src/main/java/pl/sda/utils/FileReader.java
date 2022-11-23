package pl.sda.utils;

import java.io.File;

public class FileReader {
    private static final String PATH_OPEN_WEATHER = "src/main/resources/JsonFiles/OpenWeather.json";
    private static final String PATH_WEATHER_STACK = "src/main/resources/JsonFiles/WeatherStack.json";

    public File readFileFromOpenWeather() {
        return new File(PATH_OPEN_WEATHER);
    }
    public File readFileFromWeatherStack() {
        return new File(PATH_WEATHER_STACK);
    }

}
