package pl.sda.dao;

import jakarta.persistence.*;

import java.util.Properties;

public class RemoveFromDB {

    public static void removeAllDatainDB(Properties properties){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WeatherStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("truncate table weather").executeUpdate();
            entityManager.createNativeQuery("truncate table weatheravg").executeUpdate();
            entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
            entityManager.createNativeQuery("truncate table city").executeUpdate();
            entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
            entityManager.getTransaction().commit();
        }
        finally {
            entityManagerFactory.close();
        }
    }
}
