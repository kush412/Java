/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import Main.Student;
import Main.Vaccine;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author An Dang
 */
public class MyValidation {

    protected static Scanner sc = new Scanner(System.in);

    //Input date format <dd/MM/yyyy>
    public static String inputDate(String msg, String pattern) {
        String data;
        boolean cont;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
            if (!data.matches(pattern)) {
                System.out.println("Wrong date format!");
                cont = true;
            } else {
                cont = false;
            }
        } while (cont == true);
        return data;
    }

    //Check if date is valid
    private static int validDate(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        int dayF, monthF, yearF;
        int maxd;
        dayF = Integer.parseInt(st.nextToken());
        monthF = Integer.parseInt(st.nextToken());
        yearF = Integer.parseInt(st.nextToken());
        if (dayF < 1 || dayF > 31 || monthF < 1 || monthF > 12 || yearF != 2021) {
            System.out.println("Invalid date!");
            return 0;
        }
        if (monthF == 4 || monthF == 6 || monthF == 9 || monthF == 11) {
            maxd = 30;
            if (dayF < 1 || dayF > maxd) {
                System.out.println("Invalid date!");
                return 0;
            }
        } else if (monthF == 2) {
            if (yearF % 400 == 0 || (yearF % 4 == 0 && yearF % 100 != 0)) {
                maxd = 29;
                if (dayF < 1 || dayF > maxd) {
                    System.out.println("Invalid date!");
                    return 0;
                }
            } else {
                maxd = 28;
                if (dayF < 1 || dayF > maxd) {
                    System.out.println("Invalid date!");
                    return 0;
                }
            }
        }
        return -1;
    }

    //Check if date is before today
    public static boolean isBeforeToday(String injDate) {
        int isValid = validDate(injDate);
        if (isValid == 0) {
            return false;
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate today = LocalDate.now();
            LocalDate injectionDate = LocalDate.parse(injDate, dtf);
            if (injectionDate.isAfter(today)) {
                System.out.println("The date is in the future!");
                return false;
            }
        }
        return true;
    }

    public static int printDays(String startDate, String endDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateStart = LocalDate.parse(startDate, dtf);
        LocalDate dateStop = LocalDate.parse(endDate, dtf);
        int diff = dateStop.getDayOfYear() - dateStart.getDayOfYear();
        return diff;
    }

    public static boolean checkDays(String startDate, String endDate) {
        boolean isValid = isBeforeToday(endDate);
        if (!isValid) {
            return false;
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateStart = LocalDate.parse(startDate, dtf);
            LocalDate dateStop = LocalDate.parse(endDate, dtf);
            int diff = dateStop.getDayOfYear() - dateStart.getDayOfYear();
            if ((diff / 7) < 4 || (diff / 7) > 12) {
                System.out.println("\t- The duration between 2 injections is not qualified for second injection."
                        + "\n\t- The second dose of vaccine must be given 4 to 12 weeks after the first injection");
                return false;
            }
        }
        return true;
    }

    public static boolean isRecently(String firstInjDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateStart = LocalDate.parse(firstInjDate, dtf);
        LocalDate currentDate = LocalDate.now();
        int diff = currentDate.getDayOfYear() - dateStart.getDayOfYear();
        if ((diff / 7) < 4) {
            System.out.println("\t- The duration between 2 injections is not qualified for second injection."
                    + "\n\t- The second dose of vaccine must be given 4 to 12 weeks after the first injection");
            return true;
        }
        return false;
    }

    public static ArrayList<Vaccine> loadVaccFromFile() {
        ArrayList<Vaccine> listVacc = new ArrayList<>();
        if (listVacc.size() > 0) {
            listVacc.clear();
        }
        try {
            File f = new File("vaccine.dat");
            if (!f.exists()) {
                System.out.println("File not found");
            }
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Vaccine v;
            while ((v = (Vaccine) (fo.readObject())) != null) {
                listVacc.add(v);
            }
            fo.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return listVacc;
    }

    public static boolean checkVaccineID(String vaccineID) {
        ArrayList<Vaccine> listVaccine = loadVaccFromFile();
        for (Vaccine v: listVaccine) {
            if (v.getVaccineID().equals(vaccineID)) {
                return true;
            }
        }
        return false;
    }

    public static void printVaccineList() {
        ArrayList<Vaccine> listVaccine = loadVaccFromFile();
        for (Vaccine v : listVaccine) {
            System.out.println(v);
        }
    }

    public static ArrayList<Student> loadStudFromFile() {
        ArrayList<Student> listStudent = new ArrayList<>();
        if (listStudent.size() > 0) {
            listStudent.clear();
        }
        try {
            File f = new File("student.dat");
            if (!f.exists()) {
                System.out.println("File not found");
            }
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Student st;
            while ((st = (Student) (fo.readObject())) != null) {
                listStudent.add(st);
            }
            fo.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return listStudent;
    }

    public static boolean checkStudentID(String studentID) {
        ArrayList<Student> listStudent = loadStudFromFile();
        for (Student st: listStudent) {
            if (st.getStudentID().equals(studentID)) {
                return true;
            }
        }
        return false;
    }

    public static void printStudentList() {
        ArrayList<Student> listStudent = loadStudFromFile();
        for (Student st : listStudent) {
            System.out.println(st);        }
    }

    public static String inputStringPattern(String msg, String pattern, String err) {
        String data;
        boolean cont;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim().toUpperCase();
            if (!data.matches(pattern)) {
                System.out.println(err);
                cont = true;
            } else {
                cont = false;
            }
        } while (cont == true);
        return data;
    }

    public static String inputNoSpaceString(String msg) {
        String data;
        boolean cont;
        do {
            System.out.print(msg);
            data = sc.nextLine().replaceAll("\\s+", "").trim().toUpperCase();
            if (data.length() == 0) {
                System.out.println("This field can not be empty!");
                cont = true;
            } else {
                cont = false;
            }
        } while (cont == true);
        return data;
    }

    public static String inputStringNonBlank(String msg) {
        String data;
        boolean cont;
        do {
            System.out.print(msg);
            data = sc.nextLine().replaceAll("\\s+", " ").trim().toUpperCase();
            if (data.length() == 0) {
                System.out.println("This field can not be empty!");
                cont = true;
            } else {
                cont = false;
            }
        } while (cont == true);
        return data;
    }

    public static String inputString(String msg) {
        String data;
        System.out.print(msg);
        data = sc.nextLine().replaceAll("\\s+", " ").trim().toUpperCase();
        return data;
    }

    public static boolean isContinue() {
        boolean cont;
        boolean result = false;
        do {
            System.out.print("Do you want to continue (y/n)? ");
            String answer = sc.nextLine().trim();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                result = true;
                cont = false;
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                result = false;
                cont = false;
            } else {
                cont = true;
            }
        } while (cont);
        return result;
    }

    public static boolean isContinue(String msg) {
        boolean cont;
        boolean result = false;
        do {
            System.out.print(msg);
            String answer = sc.nextLine().trim();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                result = true;
                cont = false;
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                result = false;
                cont = false;
            } else {
                cont = true;
            }
        } while (cont);
        return result;
    }
}
