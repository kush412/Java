package Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    //Check if date is after today
    public static boolean isExpired(String expDate) {
        int isValid = validDate(expDate);
        if (isValid == 0) {
            return false;
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate cDay = LocalDate.now();
            LocalDate eDay = LocalDate.parse(expDate, dtf);
            if (eDay.isBefore(cDay)) {
                System.out.println("The date is expired!");
                return false;
            }
        }
        return true;
    }

    //Compare two dates have the same year as Strings.
    public static int dateCompare(String date1, String date2) {
        StringTokenizer st1 = new StringTokenizer(date1, "/");
        StringTokenizer st2 = new StringTokenizer(date2, "/");
        int dayF1, monthF1, dayF2, monthF2;
        dayF1 = Integer.parseInt(st1.nextToken());
        monthF1 = Integer.parseInt(st1.nextToken());
        dayF2 = Integer.parseInt(st2.nextToken());
        monthF2 = Integer.parseInt(st2.nextToken());
        if (monthF1 > monthF2) {
            return -1;
        } else if (monthF1 == monthF2) {
            if (dayF1 > dayF2) {
                return -1;
            } else if (dayF1 == dayF2) {
                return 0;
            }
        }
        return 1;
    }

    //Force user to input String.
    public static String inputString(String msg) {
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

    //Force user to input no space String
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

    //Input file name to file txt && always return filename.txt
    public static String inputFileName(String msg) {
        String fileName;
        boolean cont;
        do {
            System.out.print(msg);
            fileName = sc.nextLine().replaceAll("\\s+", " ").trim();
            StringTokenizer f = new StringTokenizer(fileName, ". ");
            try {
                fileName = f.nextToken() + ".txt";
            } catch (Exception e) {
                System.out.println("Error in creating file name: " + e);
            }
            if (fileName.length() == 0) {
                System.out.println("This field can not be empty!");
                cont = true;
            } else {
                cont = false;
            }
        } while (cont == true);
        return fileName;
    }

    //Check input integer and check min && max.
    public static int inputInt(String msg, int min, int max) {
        boolean cont;
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data = 0;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());
                if (data < min || data > max) {
                    System.out.println("You must enter an integer between " + min + " and " + max);
                    cont = true;
                } else {
                    cont = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer between " + min + " and " + max);
                cont = true;
            }
        } while (cont == true);
        return data;
    }

    //Check if user want to continue the function
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

    //Check if user want to continue the function with a customized message.
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
