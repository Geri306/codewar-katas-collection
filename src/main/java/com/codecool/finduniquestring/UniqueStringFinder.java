package com.codecool.finduniquestring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueStringFinder {
    /*public String findUnique(String[] arr) {
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
    }*/

    public String findUnique(String[] strings) {
        return Arrays.stream(strings)
                .map(String::toLowerCase)
                .map(string -> string.replaceAll("\\s", ""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
