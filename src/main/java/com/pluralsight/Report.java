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

        String searchVendor = Console.promptForString("Who is the vendor you are searching for? ").trim();

        for(Transaction transaction : transactions) {

            String vendor = transaction.getVendor();

            if (searchVendor.equalsIgnoreCase(vendor.trim())){
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
//        System.out.println("""
//        ===== =========================================================================================================================
//                       ,-----.,--. ,--. ,---. ,--------. ,-----. ,--.   ,--.     ,---.  ,------.  ,---.  ,------.  ,-----.,--.  ,--.   \s
//                      '  .--./|  | |  |'   .-''--.  .--''  .-.  '|   `.'   |    '   .-' |  .---' /  O  \\ |  .--. ''  .--./|  '--'  |   \s
//                      |  |    |  | |  |`.  `-.   |  |   |  | |  ||  |'.'|  |    `.  `-. |  `--, |  .-.  ||  '--'.'|  |    |  .--.  |   \s
//                      '  '--'\\'  '-'  '.-'    |  |  |   '  '-'  '|  |   |  |    .-'    ||  `---.|  | |  ||  |\\  \\ '  '--'\\|  |  |  |   \s
//                       `-----' `-----' `-----'   `--'    `-----' `--'   `--'    `-----' `------'`--' `--'`--' '--' `-----'`--'  `--'   \s
//        ===============================================================================================================================
//        Press Enter to skip any field.
//        """);
        UI.showCustomSearch();

        LocalDate startDate = Console.promptForOptionalDate("Start Date (YYYY-MM-DD): ");
        LocalDate endDate = Console.promptForOptionalDate("End Date (YYYY-MM-DD): ");
        String description = Console.promptForOptionalString("Description: ");
        String vendor = Console.promptForOptionalString("Vendor: ").trim();
        Double amount = Console.promptForOptionalDouble("Amount: ");

        ArrayList<Transaction> filteredList = new ArrayList<>();

        // Validate date range
        if (startDate != null && endDate != null
                && startDate.isAfter(endDate)) {
            System.out.println("Start date cannot be after end date.");
            return;
        }


        boolean startDateFound = false;
        boolean endDateFound = false;
        boolean descriptionFound = false;
        boolean vendorFound = false;
        boolean amountFound = false;
        // 2. Loop through transactions
        for (Transaction transaction : transactions) {

            LocalDate transactionDate = transaction.getDate();
            boolean matches = true;

            // START DATE
            if (startDate != null) {
                if (transactionDate.isBefore(startDate)) {
                    matches = false;
                } else {
                    startDateFound = true;
                }
            }

            // END DATE
            if (endDate != null) {
                if (transactionDate.isAfter(endDate)) {
                    matches = false;
                } else {
                    endDateFound = true;
                }
            }

            // DESCRIPTION
            if (!description.isEmpty()) {
                boolean descriptionMatches =
                        transaction.getDescription().toLowerCase(Locale.ROOT)
                                .contains(description.toLowerCase(Locale.ROOT));

                if (descriptionMatches) {
                    descriptionFound = true;
                } else {
                    matches = false;
                }
            }

            // VENDOR
            if (!vendor.isEmpty()) {
                boolean vendorMatches =
                        transaction.getVendor().toLowerCase(Locale.ROOT)
                                .contains(vendor.toLowerCase(Locale.ROOT));

                if (vendorMatches) {
                    vendorFound = true;
                } else {
                    matches = false;
                }
            }

            // AMOUNT
            if (amount != null) {
                if (Double.compare(transaction.getAmount(), amount) == 0) {
                    amountFound = true;
                } else {
                    matches = false;
                }
            }

            // ADD TRANSACTION ONLY IF ALL FILTERS MATCH
            if (matches) {
                filteredList.add(transaction);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("No transactions match all your search criteria.");

            if (startDate != null && !startDateFound) {
                System.out.println("No transactions found on or after the start date.");
            }

            if (endDate != null && !endDateFound) {
                System.out.println("No transactions found on or before the end date.");
            }

            if (!description.isEmpty() && !descriptionFound) {
                System.out.println("No transactions found with that description.");
            }

            if (!vendor.isEmpty() && !vendorFound) {
                System.out.println("No transactions found with that vendor.");
            }

            //Filtering
            if (amount != null && !amountFound) {
                System.out.println("No transactions found with the specified amount.");
            }
        } else {
        Ledger.all(filteredList);
    }


    }
}