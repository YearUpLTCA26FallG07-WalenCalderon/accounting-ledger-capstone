package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args){
//        do{
//           switch(screen){
//               case "Home"->{screen = displayHomeScreen();}
//               case "Ledger"->{screen = displayLedger();}
//               case "Reports"->{screen = displayReports();}
//               case "Exit" -> {
//                       System.out.println("GoodBye!");
//                }
//               default -> {
//                   System.out.println("Invalid selection");
//               }
//           }
//        }while(screen != "EXIT");

        displayHomeScreen();

    }//merge with display home

    public static void displayHomeScreen() {
        char homeSelection;
        do {
            System.out.println("\nHome Screen");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            homeSelection = Console.promptForChar("Select an option: ");
            switch (homeSelection) {
                case 'D' -> { }
                case 'P' -> {}
                case 'L' -> displayLedger();
                case 'X' -> System.out.println("Goodbye!!");
                default -> {
                    System.out.println("Invalid selection");
                }
            }
        }while(homeSelection != 'x');
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

            ledgerSelection = Console.promptForChar("Select an option: ");
            switch (ledgerSelection){
                case 'A' -> {/*todo - display all entries*/}
                case 'D' -> {/* todo - Display only the entries that are deposits into the account*/}
                case 'P' -> {/* todo - Display only the negative entries (or payments)*/}
                case'R' -> {displayReports(); }
                case 'H' ->  {break;}
            }

        }while( ledgerSelection !=  'H');
    }// end of display ledger

    public static void displayReports(){
        int reportSelection;
        System.out.println("\nReports Screen");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor"); //todo - prompt the user for the vendor name and display all entries for that vendor
        System.out.println("0) Back");

        reportSelection = Console.promptForInt("Select an option: ");

        switch (reportSelection){
            case 1 ->
        }
    }


}//end of display reports
