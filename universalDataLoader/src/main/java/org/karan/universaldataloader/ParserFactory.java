package org.karan.universaldataloader;

public class ParserFactory {
    public static DataParser getParser(String fileType) {
        if (fileType.equalsIgnoreCase("CSV")) {
            return new CSVParser();
        } else if(fileType.equalsIgnoreCase("JSON")) {
            return new JSONParser();
        } else {
            throw new IllegalArgumentException("Unknown file format: "+ fileType);
        }
    }
}
