package pl.sda.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pl.sda.models.City;
import pl.sda.models.Weather;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ReadFromDB {

    public static void loadCitiesFromDB(Properties properties){
        List<City> city;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WeatherStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<City> typedQuery = entityManager.createQuery("SELECT c FROM City c", City.class);
            city=typedQuery.getResultList();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        city.stream().distinct().forEach(System.out::println);
    }

    public static List<Weather> weatherAndCityByName(Properties properties){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasto którego pogoda Cie interesuje");
        String cityQuery = scanner.nextLine();

        List<Weather> weather;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WeatherStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Weather> typedQuery = entityManager.createQuery("""
                            SELECT weather FROM Weather weather
                            JOIN City city
                            ON weather.cityId = city.id
                            WHERE city.`name` = :name                                                                             
                            """,
                    Weather.class
            );
            typedQuery.setParameter("name", cityQuery);
            weather=typedQuery.getResultList();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return weather;
    }
}
