package pl.sda.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.sda.models.*;
import pl.sda.utils.ApplicationPropertiesProvider;
import pl.sda.utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SentToDB {

    public static void prepareDataToSendToDB(Properties properties, List<JsonNode> gsonJson){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WeatherStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            for (JsonNode jsonNode : gsonJson) {

                City city = jsonNode.getCity();
                Weather weather = jsonNode.getWeather();
                //WeatherAvg weatherAvg = jsonNode.getWeatherAvg();
                weather.setCityId(city);
                //weatherAvg.setCityId(city);

                entityManager.persist(city);
                entityManager.persist(weather);
                //entityManager.persist(weatherAvg);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            entityManagerFactory.close();
        }
    }
    public static void sentFromJSonToDB() throws IOException {
        FileReader fileReader = new FileReader();
        File file = fileReader.readFileFromOpenWeather();
        File file2 = fileReader.readFileFromWeatherStack();
        GsonMapper gsonMapper = new GsonMapper();
        List<JsonNode> gsonJson = gsonMapper.fromJson(file);
        List<JsonNode> gsonJson2 = gsonMapper.fromJson(file2);
        SentToDB.prepareDataToSendToDB(ApplicationPropertiesProvider.getSql7578590Properties(), gsonJson);
        SentToDB.prepareDataToSendToDB(ApplicationPropertiesProvider.getSql7578590Properties(), gsonJson2);
    }

}
