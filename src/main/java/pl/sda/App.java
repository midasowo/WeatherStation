package pl.sda;

import pl.sda.dao.RemoveFromDB;
import pl.sda.gui.Gui;
import pl.sda.utils.ApplicationPropertiesProvider;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        while (true) {
            Gui.showMenu();
            int choice = Gui.getUserChoice();
            if (choice == 4) {
                RemoveFromDB.removeAllDataInDB(ApplicationPropertiesProvider.getSql7578590Properties());
                break;
            }
            BusinessLogic.handle(choice);
        }
    }
}
