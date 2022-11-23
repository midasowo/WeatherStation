package pl.sda;

import pl.sda.dao.ReadFromDB;
import pl.sda.dao.SentToDB;
import pl.sda.models.City;
import pl.sda.models.Weather;
import pl.sda.utils.ApplicationPropertiesProvider;

import java.io.IOException;
import java.util.List;

public class BusinessLogic {
    private static boolean acc = true;
    public static void handle(int choice) throws IOException {
        if (choice == 1) {
            if (acc) {
                acc = false;
                SentToDB.sentFromJSonToDB();
            }
            else {
                System.out.println("Wybór nieaktywny");
            }
        } else if (choice == 2) {
            ReadFromDB.loadCitiesFromDB(ApplicationPropertiesProvider.getSql7578590Properties());
        } else if (choice == 3) {
            final List<Weather> weatherByCityName = ReadFromDB.weatherAndCityByName(ApplicationPropertiesProvider.getSql7578590Properties());
            System.out.println(weatherByCityName);
        }
    }
}
