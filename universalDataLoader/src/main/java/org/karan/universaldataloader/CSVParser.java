package org.karan.universaldataloader;

public class CSVParser implements DataParser{
    @Override
    public void parse(String data) {
        System.out.println("--> Parsing CSV Data...");

        String[] parts = data.split(",");
        System.out.println("    Row processed: " + parts.length + " columns found.");
    }
}
