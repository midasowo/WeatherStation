package pl.sda;

import pl.sda.dao.ReadFromDB;
import pl.sda.dao.SentToDB;
import pl.sda.models.City;
import pl.sda.models.Weather;
import pl.sda.utils.ApplicationPropertiesProvider;

import java.io.IOException;

public class BusinessLogic {
    private static boolean acc = true;
    public static void handle(int choice) throws IOException {
        if (choice == 1) {
            if (acc) {
                acc = false;
                SentToDB.sendAllJsonDatatoDB();
            }
            else {
                System.out.println("Wybór nieaktywny");
            }
        } else if (choice == 2) {
            final City cityChoiceByUser = ReadFromDB.loadCityByName(ApplicationPropertiesProvider.getSql7578590Properties());
            System.out.println(cityChoiceByUser);
        } else if (choice == 3) {
            final Weather weatherByCityName = ReadFromDB.weatherAndCityByName(ApplicationPropertiesProvider.getSql7578590Properties());
            System.out.println(weatherByCityName);
        }
    }
}
