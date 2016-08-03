package string.pattern_match;

import java.util.*;

/**
 * Created by ugurdonmez on 02/08/16.
 */

/*

 google-interview-questions

Given a Pattern and a dictionary, print out all the strings that match the pattern.
where a character in the pattern is mapped uniquely to a character in the dictionary ( this is what i was given first).

e.g 1. ("abc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "cdf"
2. ("acc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "too", "paa"

 */

public class Solution {

    public static void main(String [] args) {

        String [] array1 = {"cdf", "too", "hgfdt" ,"paa"};

        System.out.println(isMatch("abc", "too"));

        System.out.println(Arrays.toString(getMatchedWords("abc", array1)));
        System.out.println(Arrays.toString(getMatchedWords("acc", array1)));
    }

    public static String [] getMatchedWords(String pattern, String [] words) {

        return Arrays.stream(words)
                .filter(s -> isMatch(pattern, s))
                .toArray(String[]::new);
    }

    public static boolean isMatch(String pattern, String word) {

        if (pattern.length() != word.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> occupied = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!occupied.contains(word.charAt(i))) {
                    map.put(pattern.charAt(i), word.charAt(i));
                    occupied.add(word.charAt(i));
                } else {
                    return false;
                }
            } else {
                if (map.get(pattern.charAt(i)) != word.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

}
