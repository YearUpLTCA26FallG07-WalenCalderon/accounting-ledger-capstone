package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static final ArrayList<Transaction> transactions = Ledger.populateTransactions();//Array on public class level

    public static void main(String[] args){
        displayHomeScreen();
    }//End of main

    public static double displayHomeScreen() {
        char homeSelection;
        double currentBalance;

        do {
            currentBalance = Ledger.calculateCurrentBalance(transactions);
            UI.showBanner();
            UI.showHomeMenu(String.format("$%.2f%n", currentBalance));

            homeSelection = Console.promptForChar("Select an option: ", "DPLX");//Taking input in char
            //What we are doing to do with the input
            switch (homeSelection) {
                case 'D' -> {Ledger.addDeposit(transactions);}
                case 'P' -> {Ledger.addPayments(transactions);}
                case 'L' -> displayLedger(currentBalance);
                case 'X' -> System.out.println("Goodbye!!");
                default -> {
                    System.out.println("Invalid selection");
                }
            }
        }while(homeSelection != 'X');
        return currentBalance;
    }//end of display home

    public static void displayLedger(double currentBalance){
        char ledgerSelection;
        do {
            UI.showLedgerMenu(String.format("$%.2f%n", currentBalance));

            ledgerSelection = Console.promptForChar("Select an option: ", "ADPRH");//taking input with char
            //What we are doing to do with the input
            switch (ledgerSelection){
                case 'A' -> {Ledger.all(transactions);}
                case 'D' -> {Ledger.deposits(transactions);}
                case 'P' -> {Ledger.payments(transactions);}
                case'R' -> displayReports(currentBalance);
                case 'H' ->  {return;}
                default -> System.out.println("Invalid option try again");
            }
        }while( true);
    }// end of display ledger

    public static void displayReports(double currentBalance){
        int reportSelection;
        do {
            UI.showReportsMenu(String.format("$%.2f%n", currentBalance));


        reportSelection = Console.promptForInt("Select an option: "); // taking input with int
            //What we are doing to do with the input
            switch (reportSelection) {
                case 1 -> { Report.monthToDate(transactions); }
                case 2 -> { Report.previousMonth(transactions); }
                case 3 -> { Report.yearToDate(transactions); }
                case 4 -> { Report.previousYear(transactions); }
                case 5 -> { Report.searchByVendor(transactions); }
                case 6 -> {Report.customSearch(transactions);}
                case 0 -> { return; }
                default -> System.out.println("Invalid option");
            }
        }while(true);
    }//end of display reports




}
