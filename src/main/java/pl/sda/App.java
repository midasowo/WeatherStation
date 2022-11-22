package pl.sda;

import pl.sda.gui.Gui;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        while (true) {
            Gui.showMenu();
            int choice = Gui.getUserChoice();
            if (choice == 4) {
                break;
            }
            BusinessLogic.handle(choice);
        }
    }
}
