package pl.sda;

import dao.ReadFromDB;
import dao.SentToDB;
import pl.sda.models.City;
import pl.sda.models.GsonMapper;
import pl.sda.models.JsonNode;
import pl.sda.models.Weather;
import pl.sda.utils.ApplicationPropertiesProvider;
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

//        gsonJson.forEach(System.out::println);
      //  SentToDB.sentFromJSonToDB(ApplicationPropertiesProvider.getSql7573592Properties(), gsonJson);

//       final City cityChooceByUser =  ReadFromDB.loadCityByName(ApplicationPropertiesProvider.getSql7573592Properties());
//        System.out.println(cityChooceByUser);
        final Weather weatherByCityName =  ReadFromDB.weatherAndCityByName(ApplicationPropertiesProvider.getSql7573592Properties());
        System.out.println(weatherByCityName);

    }
}
