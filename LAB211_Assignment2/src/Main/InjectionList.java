/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Validation.MyValidation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author An Dang
 */
public class InjectionList extends ArrayList<Injection> implements Serializable {

//    public InjectionList() {
//        super();
//    }
    private int findInjID(String aCode) {
        for (int i = 0; i < this.size(); i++) {
            if (aCode.equals(this.get(i).getInjectionID())) {
                return i;
            }
        }
        return -1;
    }

    private int findStudID(String stuID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getStudentID().equals(stuID)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isInjected(String stuID) {
        for (Injection i : this) {
            if (i.getStudentID().equals(stuID)) {
                return true;
            }
        }
        return false;
    }

    private Student getStudentByInjID(String stuID, ArrayList<Student> tmpList) {
        for (Student st : tmpList) {
            if (st.getStudentID().equals(stuID)) {
                return st;
            }
        }
        return null;
    }

    private Vaccine getVaccineByInjID(String vacID, ArrayList<Vaccine> tmpList) {
        for (Vaccine v : tmpList) {
            if (v.getVaccineID().equals(vacID)) {
                return v;
            }
        }
        return null;
    }

    private void printNotInjected() {
        ArrayList<Student> tmpList = MyValidation.loadStudFromFile();
        System.out.println("- List of student have no injection:");
        for (Student st : tmpList) {
            if (!isInjected(st.getStudentID())) {
                System.out.println(st);
            }
        }
    }

    //Print all injection in RAM
    public void printAllInjection() {
        if (this.isEmpty()) {
            System.out.println("No injection found!");
        } else {
            for (Injection inj : this) {
                System.out.print(inj);
            }
        }
    }

    //Print all injection stored in FILE
    public void printAllInjectionFromFile() {
        ArrayList<Injection> tmpList = new ArrayList<>();
        try {
            File f = new File("injection.dat");
            if (!f.exists()) {
                System.out.println("File has not been created");
            }
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Injection i;
            while ((i = (Injection) (fo.readObject())) != null) {
                tmpList.add(i);
            }
            fo.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        if (tmpList.isEmpty()) {
            System.out.println("The file is empty!");
        } else {
            for (Injection i : tmpList) {
                System.out.print(i);
            }
        }
    }

    //Load all available injection.
    public void getInjectionFromFile() {
        try {
            File f = new File("injection.dat");
            if (!f.exists()) {
                return;
            }
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Injection i;
            while ((i = (Injection) (fo.readObject())) != null) {
                this.add(i);
            }
            fo.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void addInjection() {
        do {
            if (this.size() == MyValidation.loadStudFromFile().size()) {
                System.out.println("All students are injected!");
                return;
            }
            String newInjID, newInjPlace1, newInjPlace2, newInjDate1, newInjDate2, newVaccID, newStudID;
            int pos;

            do {
                newInjID = MyValidation.inputStringPattern("Injection ID: ", "^I\\d{3,9}$",
                        "Injection ID start by I and followed by at least 3 digits but no more than 9 digits");
                pos = findInjID(newInjID);
                if (pos >= 0) {
                    System.out.println("This ID has already been used!");
                }
            } while (pos >= 0);

            do {
                newStudID = MyValidation.inputStringPattern("Enter student ID: ", "^SE\\d{5}$",
                        "Wrong format, the format is SE and 5 digits");
                if (!MyValidation.checkStudentID(newStudID)) {
                    System.out.println("Student ID not found! Please enter one of the following student ID");
                    this.printNotInjected();
                }
                if (isInjected(newStudID)) {
                    pos = findStudID(newStudID);
                    System.out.println("This student has an injection record " + this.get(pos).getInjectionID());
                    this.printNotInjected();
                }
            } while (!MyValidation.checkStudentID(newStudID) || isInjected(newStudID));

            do {
                newVaccID = MyValidation.inputStringPattern("Enter vaccine ID: ", "^COVID-V\\d{3}",
                        "Wrong format, the format is COVID-V and 3 digits");
                if (!MyValidation.checkVaccineID(newVaccID)) {
                    System.out.println("Vaccine ID not found! Please enter one of the following vaccine ID" + "\n- VACCINE LIST: ");
                    MyValidation.printVaccineList();
                }
            } while (!MyValidation.checkVaccineID(newVaccID));

            do {
                newInjDate1 = MyValidation.inputDate("First injection date <dd/MM/2021>: ", "\\d{2}/\\d{2}/\\d{4}$");
            } while (!MyValidation.isBeforeToday(newInjDate1));
            newInjPlace1 = MyValidation.inputStringNonBlank("First injection place: ");
            newInjDate2 = "";
            newInjPlace2 = "";
            Injection I = new Injection(newInjID, newStudID, newVaccID, newInjDate1, newInjPlace1, newInjDate2, newInjPlace2);
            this.add(I);
            System.out.println("Injection " + newInjID + " has been added!");

        } while (MyValidation.isContinue());
    }

    public void updateInjbyInjID() {
        String newInjDate2, newInjPlace2;
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            String fID = MyValidation.inputString("Update injection ID: ");
            int pos = findInjID(fID);
            if (pos < 0) {
                System.out.println("Injection ID not found!");
            } else {
                if (this.get(pos).getiDate2().isEmpty() && this.get(pos).getiPlace2().isEmpty() || MyValidation.isRecently(this.get(pos).getiDate1())) {
                    if (MyValidation.isRecently(this.get(pos).getiDate1())) {
                        return;
                    }
                    do {
                        System.out.println("\t- First injection date: " + this.get(pos).getiDate1());
                        System.out.println("\t- First injection place: " + this.get(pos).getiPlace1());
                        newInjDate2 = MyValidation.inputDate("\t- Second injection date <dd/MM/2021>: ", "\\d{2}/\\d{2}/\\d{4}$");
                        //int days = MyValidation.printDays(newInjDate1, newInjDate2);
                        //System.out.println("\t- Number of days between 2 injections: " + days + "\n\t- Number of weeks between 2 injection: " + (days / 7));
                    } while (!MyValidation.checkDays(this.get(pos).getiDate1(), newInjDate2));
                    this.get(pos).setiDate2(newInjDate2);
                    newInjPlace2 = MyValidation.inputStringNonBlank("\t- Second injection place: ");
                    this.get(pos).setiPlace2(newInjPlace2);
                    System.out.println("Injection " + this.get(pos).getInjectionID() + " has been updated successfully!");
                } else {
                    System.out.println("Student has completed 2 injections!");
                }
            }
        }
    }

    public void searchByStudID() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            do {
                String fID = MyValidation.inputString("Search injection information by student ID: ");
                int pos = findStudID(fID);
                if (pos < 0) {
                    System.out.println("Student ID not found!");
                } else {
                    System.out.println("\t- Injection ID: " + this.get(pos).getInjectionID()
                            + "\n" + this.getStudentByInjID(this.get(pos).getStudentID(), MyValidation.loadStudFromFile())
                            + "\n" + this.getVaccineByInjID(this.get(pos).getVaccineID(), MyValidation.loadVaccFromFile())
                            + "\n\t- First injection date: " + this.get(pos).getiDate1()
                            + ", first injection place: " + this.get(pos).getiPlace1()
                            + "\n\t- Second injection date: " + this.get(pos).getiDate2()
                            + ", second injection place: " + this.get(pos).getiPlace2());
                }
            } while (MyValidation.isContinue());
        }
    }

    public void removeByInjID() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            String rID = MyValidation.inputString("Removing injection ID: ");
            int pos = findInjID(rID);
            if (pos < 0) {
                System.out.println("No injection ID found!");
            } else {
                System.out.println("Injection ID:\n" + this.get(pos));
                if (MyValidation.isContinue("Do you want to remove injection " + rID + " (y/n)? ")) {
                    this.remove(pos);
                    System.out.println("Injection " + rID + " has been removed successfully!");
                } else {
                    System.out.println("Failed to remove injection " + rID);
                }
            }
        }
    }

    public void saveToFile() {
        try {
            FileOutputStream f = new FileOutputStream("injection.dat");
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Injection i : this) {
                fo.writeObject(i);
            }
            fo.close();
            f.close();
            System.out.println("Saved to file injection.dat successfully");
        } catch (Exception e) {
        }
    }
}
