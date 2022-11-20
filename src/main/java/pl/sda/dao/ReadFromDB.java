package pl.sda.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pl.sda.models.City;
import pl.sda.models.Weather;

import java.util.Properties;
import java.util.Scanner;

public class ReadFromDB {

    public static City loadCityByName(Properties properties){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasto:");
        String cityQuery = scanner.nextLine();

        City city;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WeatherStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<City> typedQuery = entityManager.createQuery("SELECT c FROM City c " +
                    "WHERE c.`name` = :name ", City.class);
            typedQuery.setParameter("name", cityQuery);
            city=typedQuery.getSingleResult();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return city;
    }

    public static Weather weatherAndCityByName(Properties properties){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasto którego pogoda Cie interesuje");
        String cityQuery = scanner.nextLine();

        Weather weather;
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
            weather=typedQuery.getSingleResult();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return weather;
    }
}
