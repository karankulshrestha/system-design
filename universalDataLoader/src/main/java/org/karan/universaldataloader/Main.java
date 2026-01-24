package org.karan.universaldataloader;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file format (CSV / JSON):");
        String format = scanner.nextLine();

        System.out.println("Enter raw data:");
        String data = scanner.nextLine();

        try {
            DataParser dataParser = ParserFactory.getParser(format);

            dataParser.parse(data);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}