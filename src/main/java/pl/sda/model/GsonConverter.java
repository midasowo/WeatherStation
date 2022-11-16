package pl.sda.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GsonConverter {

    public static void main(String[] args) {

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("api/OpenWeather.json"));

            //Weather weatherFromJson = gson.fromJson(reader, Weather.class);
            // convert JSON array to list of users
            List<Weather> weatherFromJson = new Gson().fromJson(reader, new TypeToken<List<Weather>>(){}.getType());

            // print users
            weatherFromJson.forEach(System.out::println);
            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
