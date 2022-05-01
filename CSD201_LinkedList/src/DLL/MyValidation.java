/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import java.util.Scanner;

/**
 *
 * @author An Dang
 */
public class MyValidation {

    protected static Scanner sc = new Scanner(System.in);

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

    public static int inputInteger(String msg) {
        int data = 0;
        try {
            System.out.print(msg);
            data = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer!");
        }
        return data;
    }

    public static double inputDouble(String msg, double min, double max) {
        boolean cont;
        if (min > max) {
            double t = min;
            min = max;
            max = t;
        }
        double data = 0.0;
        do {
            try {
                System.out.print(msg);
                data = Double.parseDouble(sc.nextLine().trim());
                if (data < min || data > max) {
                    System.out.println("You must enter a number between " + min + " and " + max);
                    cont = true;
                } else {
                    cont = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number between " + min + " and " + max);
                cont = true;
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
}
