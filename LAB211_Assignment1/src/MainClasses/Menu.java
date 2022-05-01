package MainClasses;

import java.util.*;

public class Menu {
    public static int getChoice(ArrayList<String> options) {
        boolean cont;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + " - " + options.get(i));
        }
        do {
            try {
                System.out.print("Choose your option from 1 to " + options.size() + ": ");
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 1 || choice > options.size()) {
                    System.out.println("No option found!");
                    cont = true;
                } else
                    cont = false;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number from 1 to " + options.size());
                cont = true;
            }
        } while (cont == true);
        return choice;
    }
}