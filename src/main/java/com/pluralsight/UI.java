package com.pluralsight;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.ArrayList;

public class UI {
    private static final String ANSI_cian = "\u001B[38;2;85;221;244m";  // #55DDF4

    private static final String ANSI_gold = "\u001B[38;2;242;189;96m"; // #F2BD60
    private static final String ANSI_reset = "\u001B[39m";


    public static void showBanner(){
        String banner = """
                 [cian]╱── ── ── ── ── ── ── ── ── ── ── ── ─╲
                ╱           ╭────────────────╲           ╲
                ┆          ╱ ╷   ╭─────────╮  ╲           ┆
                ┆         ╱  │   │   [gold]▄██▄[cian]  │   ╲          ┆
                ┆        ├───┤   │  [gold]▐█ ▄█▀[cian] │  ╲           ┆
                ┆        │   │   │ [gold]▐█[cian]      │     ╲        ┆
                ┆        ├───┤   ╰─────────╯      │       ┆
                ┆        │   │    [gold]$   +   -[cian]       │       ┆
                ┆        │   ├────────────────────╯       ┆
                ┆        │   │ ───────────────── ╱        ┆
                ┆        ╰───┴──────────────────╯         ┆
                ┆                                         ┆
                ┆     [gold][line1][cian]  ┆
                ┆    [gold][line2][cian]   ┆
                ┆  [gold] [line3][cian][stop]    ┆
                ┆                                         ┆
                 ╲        [gold]PERSONAL FINANCE LEDGER[cian]        ╱
                  ╲── ── ── ── ── ── ── ── ── ── ── ── ─╱[reset]""";
        String line1 = "█▀▀▄ █    █▀▀▀ █▀▀▄ ▄▀▀▀ █▀▀▀ █▀▀▄";
        String line2 ="█▄▄▀ █    █▀▀  █  █ █ ▄▄ █▀▀  █▄▄▀";
        String line3 = "█    █▄▄▄ █▄▄▄ █▄▄▀ ▀▄▄█ █▄▄▄ █ ▀▄";
        String coloredBanner = banner
                .replace("[line1]", line1)
                .replace("[line2]", line2)
                .replace("[line3]", line3)
                .replace("[stop]" , "")
                .replace("[gold]",ANSI_gold)
                .replace("[cian]",ANSI_cian)
                .replace("[reset]",ANSI_reset);


        //todo Animation
//        String[] lines = coloredBanner.split("\n");
//
//        for(int i = 0; i < lines.length; i++) {
//
//            if(lines[i] )_
//        }

        System.out.println(coloredBanner);


    }

    public static void printTransactionHeader(String title) {
        System.out.println();
        System.out.println(ANSI_gold + title + ANSI_reset);

        System.out.print(ANSI_cian);
        printTransactionLine(
                "D A T E",
                "D E S C R I P T I O N",
                "V E N D O R",
                "A M O U N T"
        );
        System.out.println("─".repeat(68) + ANSI_reset);
    }

     public static void printTransactionLine(
            String date, String description, String vendor, String amount) {
        System.out.printf("%-10.10s  %-24.24s  %-16.16s  %12s%n"+ ANSI_reset,
                date, description, vendor, amount);

    }



}
