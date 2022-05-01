package Main;

import Validation.MyValidation;
import java.util.ArrayList;

/**
 *
 * @author An Dang
 */
public class Tester {

    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();
        options.add("Show the injection stored in file");
        options.add("Show the current injection information");
        options.add("Add new injection");
        options.add("Update injection information");
        options.add("Delete injection by injection ID");
        options.add("Search injection by student ID");
        options.add("Store data to file");
        options.add("Quit");
        int choice;
        System.out.println("\nWelcome to Injection Management - @2021 by <SE160873 - Dang Phuc An>");
        InjectionList list = new InjectionList();
        list.getInjectionFromFile();
        do {
            System.out.println("Select the options below:");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 0:
                    list.printAllInjectionFromFile();
                    break;
                case 1:
                    list.printAllInjection();
                    break;
                case 2:
                    list.addInjection();
                    break;
                case 3:
                    list.updateInjbyInjID();
                    break;
                case 4:
                    list.removeByInjID();
                    break;
                case 5:
                    list.searchByStudID();
                    break;
                case 6:
                    list.saveToFile();
                    break;
                case 7:
                    if (MyValidation.isContinue("Do you want to save everything before exit (y/n)? "))
                        list.saveToFile();
                    System.out.println("END PROCESS!");
            }
        } while (choice >= 0 && choice < 7);
    }

}
