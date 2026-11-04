package com.pluralsight;
import java.util.Scanner;

public class Console {
    private static final Scanner sc = new Scanner(System.in);



    public static char promptForChar(String prompt, String validOptions) {
       while(true) {
           System.out.print(prompt);
           char character = 0;
           String input = sc.nextLine().trim().toUpperCase();
           if (input.length() == 1 ){
            character = input.charAt(0);
           }

           if (validOptions.indexOf(character) >= 0){
               return character;
           }
       }

    }

    public static int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }

        }
    }
    public static String promptForString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Enter a valid text please");
            } else {
                return input;
            }

        }
    }

        /**
         * Allows the user to input String with empty spaces
         */
        public static String promptForOptionalString(String prompt) {
            System.out.println(prompt);
            return sc.nextLine();
        }

    /**
     * Allows the user to input Double
     *with empty spaces
     */
    public static Double promptForOptionalDouble(String prompt) {

        while(true) {
            System.out.println(prompt);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                return null;
            }
            try {
                return Double.parseDouble(input);
            }catch (NumberFormatException e){
                System.out.println("Enter a valid amount or press enter to skip.");
            }
        }
    }


    public static double promptForDouble(String prompt){
        while(true) {
            System.out.print(prompt);

            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    public static long promptForLong(String prompt) {
    while(true) {
        System.out.println(prompt);
            try {
                return Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }


}