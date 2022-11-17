package pl.sda;

import dao.SentToDB;
import pl.sda.models.GsonMapper;
import pl.sda.models.JsonNode;
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


        SentToDB.sentFromJSonToDB(ApplicationPropertiesProvider.getSql7573592Properties(), gsonJson);

        gsonJson.forEach(System.out::println);

    }
}
