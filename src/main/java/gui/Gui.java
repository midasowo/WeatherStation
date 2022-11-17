package gui;

import java.util.Scanner;

public class Gui {

    public static void showMenu() {
        System.out.println("Co chcesz zrobić?: ");
        System.out.println("1 - Dodać lokalizację do bazy danych");
        System.out.println("2 - Wyświetlić aktualnie dodane lokalizację");
        System.out.println("3 - Pobrać wartości pogodowe dla podanej lokalizacji");
        System.out.println("4 - Zakończyć pracę");
    }

    public static int getUserChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prosze podac wybor: ");
        return scanner.nextInt();
    }

}
