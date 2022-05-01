package Main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author An Dang
 */
public class Menu {
    public static int getChoice(ArrayList<String> options) {
        boolean cont;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i) + " - " + options.get(i));
        }
        do {
            try {
                System.out.print("Choose your option from 0 to " + (options.size() - 1) + ": ");
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 0 || choice > options.size()) {
                    System.out.println("No option found!");
                    cont = true;
                } else
                    cont = false;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number from 0 to " + (options.size()-1));
                cont = true;
            }
        } while (cont == true);
        return choice;
    }
}
