package org.karan.universaldataloader;

public class JSONParser implements DataParser{
    @Override
    public void parse(String data) {
        System.out.println("--> Parsing JSON Data...");
        System.out.println("    JSON Object detected. Keys extracted.");
    }
}
