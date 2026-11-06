package com.pluralsight;
import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Ledger {
    /**
     * This method is for
     * @param transactions
     */
    public static void all(ArrayList <Transaction> transactions ) {
        UI.printTransactionHeader("""
        ┌─┐ │   │     ─┬─ ┌─┐ ┌─┐ ╷ ╷ ┌── ┌─┐ ┌── ─┬─ ─┬─ ┌─┐ ╷ ╷ ┌──
        ├─┤ │   │      │  ├─┘ ├─┤ │╲│ └─┐ ├─┤ │    │   │  │ │ │╲│ └─┐
        │ │ └── └──    ╵  │ ╲ │ │ │ ╵ ──┘ │ │ └──  ╵  ─┴─ └─┘ │ ╵ ──┘\n""");
        for(Transaction transaction : transactions){
            displayTransaction(transaction);
        }

    }

    /**
     * This method is for  populating the Arraylist Transactions with the csv.
     * @return ArrayList <Transaction>
     */
    public static ArrayList <Transaction> populateTransactions(){
        ArrayList <Transaction> transactions = new ArrayList<>();
        try {
            //Creating objects
            FileReader file = new FileReader("src/main/resources/transactions.csv" );
            //FileWriter writer = new FileWriter("src/main/resources/transactions.csv", true);
            BufferedReader reader = new BufferedReader(file);



            String line;//Line to read
            reader.readLine();

            //Meanwhile there is no null value keep reading
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split("[|]");//Making
                LocalDate date = LocalDate.parse(tokens[0]);
                LocalTime time = LocalTime.parse(tokens[1]);
                String description = tokens[2];
                String vendor = tokens[3];
                double amount = Double.parseDouble(tokens[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        transactions.sort(
                Comparator.comparing(Transaction::getDate) //Comparing by date
                        .thenComparing(Transaction::getTime) //Comparing by time
                        .reversed()//reversing the sorted list (ex: instead of 12345 is 54321)
        );
        return transactions;

    }

    /**
     * Making the display deposits here
     * @param transactions
     */
    public static void deposits(ArrayList<Transaction>transactions){
        UI.printTransactionHeader("""
        ┌─╮ ┌── ┌─┐ ┌─┐ ┌── ─┬─ ─┬─ ┌──
        │ │ ├── ├─┘ │ │ └─┐  │   │  └─┐
        └─╯ └── │   └─┘ ──┘ ─┴─  ╵  ──┘\n""");

        for(Transaction transaction : transactions){
            if(transaction.getAmount() > 0) {
                displayTransaction(transaction);
            }

        }
    }

    public static void addDeposit(ArrayList<Transaction> transactions){
        try {

            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            String description = Console.promptForString("Description: ");
            String vendor = Console.promptForString("Vendor: ");
            double amount;
            do {
                amount = Console.promptForDouble("Amount: ");

                if(amount <= 0 ){
                    System.out.println("Payment should be more than 0");
                }

            }while (amount <= 0);
            FileWriter writer = new FileWriter("src/main/resources/transactions.csv", true);

            Transaction transaction = new Transaction(date, time,description,vendor, amount);
            String line = String.format("%s|%s|%s|%s|%.2f%n",
                    transaction.getDate(),
                    transaction.getTime().format(
                            DateTimeFormatter.ofPattern("HH:mm:ss")
                    ),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount()
            );
            writer.write(line);

            transactions.add(transaction);

            transactions.sort(
                    Comparator.comparing(Transaction::getDate) //Comparing by date
                            .thenComparing(Transaction::getTime) //Comparing by time
                            .reversed()//reversing the sorted list (ex: instead of 12345 is 54321)
            );
            writer.close();

        }catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    /**
     * Making the display payments here
     * @param transactions
     */
    public static void payments(ArrayList<Transaction>transactions){
        UI.printTransactionHeader("""
        ┌─┐ ┌─┐ ╲ ╱ ╷╲╱╷ ┌── ╷ ╷ ─┬─ ┌──
        ├─┘ ├─┤  ┬  │  │ ├── │╲│  │  └─┐
        │   │ │  ╵  │  │ └── │ ╵  ╵  ──┘\n""");

        for(Transaction transaction : transactions){
            if(transaction.getAmount() < 0) {
                displayTransaction(transaction);
            }

        }
    }

    public static void addPayments(ArrayList<Transaction>transactions){

        try {

            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            String description = Console.promptForString("Description: ");
            String vendor = Console.promptForString("Vendor: ");
            double amount;
            do {
                amount = Console.promptForDouble("Amount: ");

                if(amount <= 0 ){
                    System.out.println("Payment should be more than 0");
                }

            }while (amount <= 0);

            amount = -Math.abs(amount);

            FileWriter writer = new FileWriter("src/main/resources/transactions.csv", true);

            Transaction transaction = new Transaction(date, time,description,vendor, amount);
            /*String line = String.format("%s|%s|%s|%s|%.2f%n",
                    transaction.getDate(),
                    transaction.getTime().format(
                            DateTimeFormatter.ofPattern("HH:mm:ss")
                    ),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount()*/

            String line = String.format("%s|%s|%s|%s|%.2f%n",
                    transaction.getDate(),
                    transaction.getTime().format(
                            DateTimeFormatter.ofPattern("HH:mm:ss")
                    ),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount()

            );
            writer.write(line);

            transactions.add(transaction);

            transactions.sort(
                    Comparator.comparing(Transaction::getDate) //Comparing by date
                            .thenComparing(Transaction::getTime) //Comparing by time
                            .reversed()//reversing the sorted list (ex: instead of 12345 is 54321)
            );
            writer.close();

        }catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }

    }

    /**
     * Calculating the current balance of the account
     * @param transactions
     * @return double current balance d balance
     */
    public static double calculateCurrentBalance(ArrayList<Transaction> transactions){
        double balance = 0;

        for(Transaction transaction : transactions){
            balance += transaction.getAmount();
        }
        return balance;
    }

    public static void displayTransaction(Transaction transaction) {
        String amount = NumberFormat.getCurrencyInstance(Locale.US)
                        .format(transaction.getAmount());

        String displayTime = transaction.getTime().format(
                DateTimeFormatter.ofPattern("hh:mm a", Locale.US)
        );

        UI.printTransactionLine(
                transaction.getDate().toString(),
                displayTime,
                transaction.getDescription(),
                transaction.getVendor(),
                amount
        );
    }



}
