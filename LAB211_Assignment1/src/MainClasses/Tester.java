package MainClasses;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();
        options.add("Add a new food");
        options.add("Search a food by name");
        options.add("Remove the food by ID");
        options.add("Print the food list in the descending order of expired date");
        options.add("Store the food list to file");
        options.add("Quit");
        int choice;
        FoodList list = new FoodList();
        do {
            System.out.println("\nWelcome to Food Management - @2021 by <SE160873 - Dang Phuc An>");
            System.out.println("Select the options below:");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    list.addFood();
                    break;
                case 2:
                    list.searchFood();
                    break;
                case 3:
                    list.removeByID();
                    break;
                case 4:
                    list.printOut();
                    break;
                case 5:
                    list.saveToFile();
                    break;
                case 6:
                    System.out.println("END PROCESS!");
            }
        } while (choice > 0 && choice < options.size());
    }
}