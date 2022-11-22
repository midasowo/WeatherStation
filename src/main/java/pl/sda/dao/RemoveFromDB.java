package pl.sda.dao;

import jakarta.persistence.*;
import pl.sda.models.City;
import pl.sda.models.Weather;

import java.util.Properties;

public class RemoveFromDB {

    public static void removeAllEntitiesFromDBAfterWork(Properties properties){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WeatherStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        try{
            entityManager.getTransaction().begin();
            City  city = new City();
            entityManager.persist(city);
           /* entityManager.flush();
            entityManager.clear();*/

            city = entityManager.find(City.class, city.getId());

            entityManager.remove(city);
            entityManager.flush();
            entityManager.clear();
            entityManager.getTransaction().commit();
        }



        finally {

            entityManagerFactory.close();
        }
    }


}
