package pl.sda;

import pl.sda.models.GsonMapper;
import pl.sda.models.JsonNode;
import pl.sda.utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        File file = fileReader.readFile();

        GsonMapper gsonMapper = new GsonMapper();

        //Map json to object
        List<JsonNode> gsonJson = gsonMapper.fromJson(file);


        System.out.println(gsonJson.get(0).getCoord().getLon());
        System.out.println(gsonJson.get(0).getCoord().getLat());
        System.out.println(gsonJson.get(1).getWeather().getWindSpeed());
        System.out.println(gsonJson.get(2).getWeather().getWindSpeed());
        System.out.println(gsonJson.get(3).getWeather().getWindSpeed());
        gsonJson.forEach(System.out::println);

    }
}
