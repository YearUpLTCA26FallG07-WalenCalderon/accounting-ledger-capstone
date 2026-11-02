package com.pluralsight;
import java.util.Scanner;

public class Console {
    private static final Scanner sc = new Scanner(System.in);

    public static char displayHomeScreen() {

        System.out.println("\nHome Screen");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("3- Find all products within a price range");
        System.out.println("4- Add a new product");
        System.out.println("X) Exit");

        return promptForChar("Select an option: ");
    }

    public static char promptForChar(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim().toUpperCase().charAt(0);
    }

    public static int promptForInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static double promptForDouble(String prompt){
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine());
    }

    public static long promptForLong(String prompt){
        System.out.println(prompt);
        return Long.parseLong(sc.nextLine());

    }
}