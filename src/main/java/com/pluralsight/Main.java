package com.pluralsight;

public class Main {
    public static void main(String[] args){
        char homeSelection;
        char ledgerSelection;

        do{
           homeSelection = Console.displayHomeScreen();
           switch(homeSelection){
               case 'D'->{}
               case 'P'=>{}
               case 'L'->{
                   Console.ledger();

               }
               case 'X'={};

               default -> {
                   System.out.println("Invalid selection");
               }
           }
        }while(true);

    }

}
