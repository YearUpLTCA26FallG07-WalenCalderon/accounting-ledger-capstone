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
        System.out.print(prompt);
        String input = sc.nextLine();

        while (true) {
            if (input.isEmpty()) {
                System.out.println("Enter a valid text please");
            }
            else{return input;}

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
        System.out.println(prompt);
    while(true) {
            try {
                return Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }


}