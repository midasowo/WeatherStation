package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.sda.models.City;
import pl.sda.models.JsonNode;
import pl.sda.models.Weather;

import java.util.List;
import java.util.Properties;

public class SentToDB {



    public static void sentFromJSonToDB(Properties properties, List<JsonNode> gsonJson){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WeatherStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            for (JsonNode jsonNode : gsonJson) {

                City city = jsonNode.getCity();
                Weather weather = jsonNode.getWeather();
                weather.setCityId(city);

                entityManager.persist(city);
                entityManager.persist(weather);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            entityManagerFactory.close();
        }
    }
}
