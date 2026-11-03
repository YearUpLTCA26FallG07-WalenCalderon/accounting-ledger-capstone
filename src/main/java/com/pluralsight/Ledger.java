package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Ledger {
    /**
     * This method is for
     * @param transactions
     */
    public static void all(ArrayList <Transaction> transactions ) {
        Transaction transaction;
        try {

            for (int i = 0; i < transactions.size(); i++) {
                transaction = transactions.get(i);
                System.out.printf("%s | %s | %s | %s | %.2f%n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount()
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
                //Writing on JSON formatt
               /* writer.write("\n");
                writer.write(String.format(" {\\\"id\\\": %d, \\\"name\\\": \\\"%s\\\", \\\"grossPay\\\": %.2f} ",
                        .getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay()));


                //Old version of printing files---------------------------------------------------------------------|
                    /*System.out.printf("%d | %s | $%.2f%n",
                            employee.getEmployeeId(),
                            employee.getName(),
                            employee.getGrossPay());*/
                //--------------------------------------------------------------------------------------------------|*/
            }
            //writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return transactions;

    }

    /**
     * Making the display deposits here
     * @param transactions
     */
    public static void deposits(ArrayList<Transaction>transactions){
        for(Transaction transaction : transactions){
            if (transaction.getAmount() > 0){
                System.out.printf("%s | %s | %s | %s | %.2f%n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount()
                );
            }
        }

    }

    public static void addDeposit(){

    }

    /**
     * Making the display payments here
     * @param transactions
     */
    public static void payments(ArrayList<Transaction>transactions){
        for(Transaction transaction : transactions){
            if (transaction.getAmount() < 0){
                System.out.printf("%s | %s | %s | %s | %.2f%n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount()
                );
            }
        }
    }

    public static void addPayments(){}

    /**
     * Calculating the current balance of the account
     * @param transactions
     * @return double curremt balace d balance
     */
    public static double calculateCurrentBalance(ArrayList<Transaction> transactions){
        double balance = 0;

        for(Transaction transaction : transactions){
            balance += transaction.getAmount();
        }
        return balance;
    }



}
