package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Ledger {
    public static void all(){
        try {
            FileReader reader = new FileReader("src/main/resources/transactions.csv");
            //FileWriter writer = new FileWriter("src/main/resources/transactions.csv", true );
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void deposits(){

    }

    public static void addDeposit(){

    }


    public static void payments(){}





}
