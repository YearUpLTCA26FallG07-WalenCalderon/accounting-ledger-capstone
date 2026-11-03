package com.pluralsight;
import java.util.ArrayList;

public class Main {
    public static final ArrayList<Transaction> transactions = Ledger.populateTransactions();//Array on public class level

    public static void main(String[] args){
        displayHomeScreen();
    }//End of main

    public static void displayHomeScreen() {
        char homeSelection;
        double currentBalance = 0; //todo the curret balance
        do {
            System.out.println("\nHome Screen");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println("Curret Balance" + currentBalance);

            homeSelection = Console.promptForChar("Select an option: ", "DPLX");//Taking input in char
            switch (homeSelection) {
                case 'D' -> {}
                case 'P' -> {}
                case 'L' -> displayLedger();
                case 'X' -> System.out.println("Goodbye!!");
                default -> {
                    System.out.println("Invalid selection");
                }
            }
        }while(homeSelection != 'X');
    }//end of display home

    public static void displayLedger(){
        char ledgerSelection;
        do {
            System.out.println("\nLedger Screen");
            System.out.println("A) All");//todo - Display all entries
            System.out.println("D) Deposits");//todo - Display only the entries that are deposits into the account
            System.out.println("P) Payments"); //todo - Display only the negative entries (or payments)
            System.out.println("R) Reports");//todo - A new screen that allows the user to run pre-defined reports or to run a custom search
            System.out.println("H) Home"); // todo - go back to the home page

            ledgerSelection = Console.promptForChar("Select an option: ", "ADPRH");//taking input with char
            switch (ledgerSelection){
                case 'A' -> {Ledger.all(transactions);}
                case 'D' -> {/* todo - Display only the entries that are deposits into the account*/}
                case 'P' -> {/* todo - Display only the negative entries (or payments)*/}
                case'R' -> displayReports();
                case 'H' ->  {return;}
                default -> System.out.println("Invalid option");
            }
        }while( true);
    }// end of display ledger

    public static void displayReports(){
        int reportSelection;
        do {
        System.out.println("\nReports Screen");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor"); //todo - prompt the user for the vendor name and display all entries for that vendor
        System.out.println("0) Back");

        reportSelection = Console.promptForInt("Select an option: "); // taking input with int
            //What we going to do with the input
            switch (reportSelection) {
                case 1 -> { /* TODO */ }
                case 2 -> { /* TODO */ }
                case 3 -> { /* TODO */ }
                case 4 -> { /* TODO */ }
                case 5 -> { /* TODO */ }
                case 0 -> { return; }
                default -> System.out.println("Invalid option");
            }
        }while(true);
    }//end of display reports




}
