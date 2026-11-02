package com.pluralsight;
import java.util.Scanner;

public class Console {
    private static final Scanner sc = new Scanner(System.in);

    public static char displayHomeScreen() {

        System.out.println("\nHome Screen");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");

        return promptForChar("Select an option: ");
    }

    public static char ledger(){
        System.out.println("\nLedger Screen");
        System.out.println("A) All");//todo - Display all entries
        System.out.println("D) Deposits");//todo - Display only the entries that are deposits into the account
        System.out.println("P) Payments"); //todo - Display only the negative entries (or payments)
        System.out.println("R) Reports");//todo - A new screen that allows the user to run pre-defined reports or to run a custom search
        System.out.println("H) Home"); // todo - go back to the home page

        return promptForChar("Select an option: ");
    }

    public static int displayReports(){
        System.out.println("\nReports Screen");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor"); //todo - prompt the user for the vendor name and display all entries for that vendor
        System.out.println("0) Back");

        return promptForInt("Select an option: ");
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