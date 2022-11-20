package pl.sda;

import pl.sda.dao.ReadFromDB;
import pl.sda.models.City;
import pl.sda.models.Weather;
import pl.sda.utils.ApplicationPropertiesProvider;

public class BusinessLogic {
    public static void handle(int choice) {
        if (choice == 1) {
            System.out.println("!!! Ten fragment do dopytania prowadzącego zajęcia !!!");
        } else if (choice == 2) {
            final City cityChoiceByUser = ReadFromDB.loadCityByName(ApplicationPropertiesProvider.getSql7573592Properties());
            System.out.println(cityChoiceByUser);
        } else if (choice == 3) {
            final Weather weatherByCityName = ReadFromDB.weatherAndCityByName(ApplicationPropertiesProvider.getSql7573592Properties());
            System.out.println(weatherByCityName);
        }
    }
}
