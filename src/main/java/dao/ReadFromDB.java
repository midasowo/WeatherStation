package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pl.sda.models.City;

import java.util.Properties;
import java.util.Scanner;

public class ReadFromDB {

    public static City loadCityByName(Properties properties){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasto którego pogoda Cie interesuje");
        String cityQuery = scanner.nextLine();

        City city = null;
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
}
