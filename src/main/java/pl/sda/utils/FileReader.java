package pl.sda.utils;

import java.io.File;

public class FileReader {
    private static final String PATH = "src/main/resources/OpenWeather.json";

    public File readFile() {
        return new File(PATH);
    }
}