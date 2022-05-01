package MainClasses;

import java.util.*;
import Validation.MyValidation;
import java.io.FileWriter;
import java.io.IOException;

public class FoodList extends ArrayList<Food> {

    protected boolean cont;

    public FoodList() {
        super();
    }

    // Find ID
    private int find(String aCode) {
        for (int i = 0; i < this.size(); i++) {
            if (aCode.equals(this.get(i).getID())) {
                return i;
            }
        }
        return -1;
    }

    // Add food(s) to list.
    public void addFood() {
        do {
            String newID, newName, newType, newPlace, newExpDate;
            int newWeight, pos;

            do {
                newID = MyValidation.inputNoSpaceString("Food's ID: ");
                pos = find(newID);
                if (pos >= 0) {
                    System.out.println("\tThis code has already been used!");
                }
            } while (pos >= 0);
            newName = MyValidation.inputString("Food's name: ");
            newWeight = MyValidation.inputInt("Food's weight: ", 1, 100000);
            newType = MyValidation.inputString("Food's type: ");
            newPlace = MyValidation.inputString("Food's place: ");
            do {
                newExpDate = MyValidation.inputDate("Food's expired date <dd/MM/2021>: ", "\\d{2}/\\d{2}/\\d{4}$");
                cont = MyValidation.isExpired(newExpDate);
            } while (!cont);

            Food f = new Food(newID, newName, newWeight, newType, newPlace, newExpDate);
            this.add(f);
            System.out.println("Food " + newID + " has been added!");

            cont = MyValidation.isContinue();
        } while (cont == true);
    }

    // Search food that contains input sequence.
    public void searchFood() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            do {
                boolean found = false;
                String sName = MyValidation.inputString("Search food by name: ");
                for (Food f : this) {
                    if (f.getName().contains(sName)) {
                        System.out.print("Found " + f.toString());
                        found = true;
                    }
                }
                if (found == false) {
                    System.out.println("Food " + sName + " doesn not exist!");
                }
                cont = MyValidation.isContinue();
            } while (cont == true);
        }
    }

    // Remove food by ID.
    public void removeByID() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            String rID = MyValidation.inputNoSpaceString("Removing food's ID: ");
            int pos = find(rID);
            if (pos < 0) {
                System.out.println("No ID found!");
            } else {
                cont = MyValidation.isContinue("Do you want to remove food " + rID + " (y/n)? ");
                if (cont == true) {
                    this.remove(pos);
                    System.out.println("Food " + rID + " has been removed successfully!");
                } else {
                    System.out.println("Failed to remove food " + rID + "!");
                }
            }
        }
    }

    // Print list sorted by expDate.
    public void printOut() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            Collections.sort(this, new Comparator<Food>() {
                @Override
                public int compare(Food t, Food t1) {
                    switch (MyValidation.dateCompare(t.getExpDate(), t1.getExpDate())) {
                        case -1:
                            return -1;
                        case 0:
                            return 0;
                        default:
                            return 1;
                    }
                }
            });

            System.out.println("Food list:");
            for (Food f : this) {
                System.out.print(f);
            }
        }
    }

    // Save list to file that user named.
    public void saveToFile() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            try {
                String fName = MyValidation.inputFileName("File name: ");
                FileWriter wr = new FileWriter(fName);
                for (Food f : this) {
                    String str = f.toString();
                    wr.write(str);
                }
                wr.close();
                System.out.println("Saved to file " + fName + " successfully!");
            } catch (IOException ex) {
                System.out.println("Error in creating file: " + ex);
            }
        }
    }
}