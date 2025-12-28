package org.karan.urlshortener.util;

public class Base62Encoder {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long number) {
        StringBuilder sb = new StringBuilder();

        while(number > 0) {
            sb.append(BASE62.charAt((int) (number % 62)));
            number /= 62;
        }

        return sb.reverse().toString();
    }

    public static long decode(String str) {
        long number = 0;

        for(char c: str.toCharArray()) {
            number = number * 62 + BASE62.indexOf(c);
        }

        return number;
    }
}
