package pl.sda;

import pl.sda.dao.RemoveFromDB;
import pl.sda.dao.SentToDB;
import pl.sda.gui.Gui;
import pl.sda.models.GsonMapper;
import pl.sda.models.JsonNode;
import pl.sda.utils.ApplicationPropertiesProvider;
import pl.sda.utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {



        while (true) {
            Gui.showMenu();
            int choice = Gui.getUserChoice();
            if (choice == 4) {
                RemoveFromDB.removeAllDatainDB(ApplicationPropertiesProvider.getSql7578590Properties());
                break;
            }
            BusinessLogic.handle(choice);
        }
    }
    private static void sendAllJsonDatatoDB() throws IOException {
        FileReader fileReader = new FileReader();
        File file = fileReader.readFile();
        GsonMapper gsonMapper = new GsonMapper();
        List<JsonNode> gsonJson = gsonMapper.fromJson(file);
        SentToDB.sentFromJSonToDB(ApplicationPropertiesProvider.getSql7578590Properties(), gsonJson);
    }
}
