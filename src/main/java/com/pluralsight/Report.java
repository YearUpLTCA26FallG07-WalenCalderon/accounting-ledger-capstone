package com.pluralsight;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Locale;

public class Report {

    public static void monthToDate(ArrayList<Transaction> transactions) {

        LocalDate today = LocalDate.now();
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

       for(Transaction transaction : transactions){
           LocalDate transactionDate = transaction.getDate();

           if((transactionDate.getMonthValue() == today.getMonthValue()
                   && transactionDate.getYear() == today.getYear()
                   && !transactionDate.isAfter(today))){
               filteredTransactions.add(transaction);
           }
       }
        Ledger.all(filteredTransactions);

    }

    public static void previousMonth(ArrayList<Transaction> transactions) {
        LocalDate previousMonth = LocalDate.now().minusMonths(1);
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions){
            LocalDate transactionDate = transaction.getDate();

            if (transactionDate.getMonthValue() == previousMonth.getMonthValue()
                    && transactionDate.getYear() == previousMonth.getYear()) {

                filteredTransactions.add(transaction);
            }
        }
        Ledger.all(filteredTransactions);
    }

    public static void yearToDate(ArrayList<Transaction> transactions) {
        LocalDate today = LocalDate.now();
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();

            if (transactionDate.getYear() == today.getYear()
                    && !transactionDate.isAfter(today)) {

                filteredTransactions.add(transaction);
            }
        }

        Ledger.all(filteredTransactions);
    }

    public static void previousYear(ArrayList<Transaction> transactions) {
        LocalDate previousYear = LocalDate.now().minusYears(1);
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();

            if (transactionDate.getYear() == previousYear.getYear()) {

                filteredTransactions.add(transaction);
            }
        }

        Ledger.all(filteredTransactions);
    }

    public static void searchByVendor(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

        String searchVendor = Console.promptForString("Who is the vendor you are searching for? ");

        for(Transaction transaction : transactions) {

            String vendor = transaction.getVendor();

            if (searchVendor.equalsIgnoreCase(vendor)){
                filteredTransactions.add(transaction);

            }
        }
        if (filteredTransactions.isEmpty()){
            System.out.println("Your vendor is not on the transaction's list");
        }

        Ledger.all(filteredTransactions);
    }

    // BONUS CHALLENGE
    public static void customSearch(ArrayList<Transaction> transactions) {
        // 1. Ask for optional search criteria
        System.out.println("""
        ===== CUSTOM SEARCH =====
        Press Enter to skip any field.
        """);
        LocalDate startDate = Console.promptForOptionalDate("Start Date (YYYY-MM-DD): ");
        LocalDate endDate = Console.promptForOptionalDate("End Date (YYYY-MM-DD): ");
        String description = Console.promptForOptionalString("Description: ");
        String vendor = Console.promptForOptionalString("Vendor: ");
        Double amount = Console.promptForOptionalDouble("Amount: ");

        ArrayList<Transaction> filteredList = new ArrayList<>();
        // 2. Loop through transactions
        for (Transaction transaction : transactions) {

            // 3. Check which criteria were provided
            LocalDate transactionDate = transaction.getDate();
            boolean matches = true;

            if (startDate != null && transactionDate.isBefore(startDate)) { // if it is not empty and is before the start date is false
                matches = false;
            }

            if (endDate != null && transactionDate.isAfter(endDate)) { //if it is not empty and is after the end date is false
                matches = false;
            }



            //in order to get the Stardate and the endDate--------------------------------------------------------------|
            if(!description.isEmpty()
            && !transaction.getDescription().toLowerCase().contains(description.toLowerCase())){
                matches = false;
                System.out.println("The description provided is not available");
            }
            //in order to get description-------------------------------------------------------------------------------|


            //in order to get the vendor--------------------------------------------------------------------------------|

            if(!vendor.isEmpty()
                    && !transaction.getVendor().toLowerCase().contains(vendor.toLowerCase())){
                matches = false;
                System.out.println("The vendor provided is not available");

            }

            //in order to get the amount--------------------------------------------------------------------------------|

            if(amount != null && transaction.getAmount() != amount){
                matches = false;
                System.out.println("The amount provided is not available");
            }

            // 4. Display matching transactions
            if (matches) {
                filteredList.add(transaction);
                System.out.println(filteredList);
            }




        }





    }
}