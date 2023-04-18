package com.codecool.abfindtheuniquestring;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("kata: find the unique string: ");
    }


    public static String findUniq(String[] arr) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (String str : arr) {
            String strLower = str.toLowerCase();

            for (int j = 0; j < strLower.length(); j++) {
                char c = strLower.charAt(j);
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
        }

        Character leastCommonChar = null;
        for (Character c : charCounts.keySet()) {
            if (leastCommonChar == null || charCounts.get(c) < charCounts.get(leastCommonChar)) {
                leastCommonChar = c;
            }
        }

        if (leastCommonChar != null) {
            for (String s : arr) {
                if (s.toLowerCase().indexOf(leastCommonChar) != -1) {
                    return s;
                }
            }
        }

        return null;
    }

}
