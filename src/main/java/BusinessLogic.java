import dao.ReadFromDB;
import gui.Gui;
import pl.sda.utils.ApplicationPropertiesProvider;

import java.util.Scanner;

public class BusinessLogic {
    public void handle(){
        int choice=Gui.getUserChoice();
        if(choice ==1){

        } else if (choice==2) {

        } else if (choice==3) {
            ReadFromDB.loadCityByName(ApplicationPropertiesProvider.getSql7573592Properties());
        } else {

        }
    }
}
