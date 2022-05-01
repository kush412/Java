/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import java.util.ArrayList;

/**
 *
 * @author dangp
 */
public class Tester {
    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();
        options.add("Add new student");
        options.add("Count the number of students in class");
        options.add("Sorting student list by ascending order of GPA");
        options.add("Print out student list by class order");
        options.add("Quit");
        int choice;
        StudentDLL list = new StudentDLL();
        do {
            System.out.println("\nWelcome to Student Management - @2021 by <SE160873 - Dang Phuc An>");
            System.out.println("Select the options below:");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.countStud();
                    break;
                case 3:
                    list.sortMark();
                    break;
                case 4:
                    list.printByClass();
                    break;
                case 5:
                    System.out.println("END PROCESS!!!");
            }
        } while (choice > 0 && choice < options.size());
    }
}
