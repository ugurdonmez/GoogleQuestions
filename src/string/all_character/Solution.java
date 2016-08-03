package string.all_character;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ugurdonmez on 27/07/16.
 */


/*

Given set of characters and a dictionary find the minimum length word that
contains all the word from the given word

 */

public class Solution {

    public static Optional<String> getMinimumLengthWord(List<String> dictionary, Set<Character> characterSet) {

        int minLength = 0;
        String result = null;

        for (String str : dictionary) {
            if (isIncludeAllChars(str, characterSet)) {
                if (str.length() < minLength) {
                    minLength = str.length();
                    result = str;
                }
            }
        }

        return Optional.ofNullable(result).filter(s -> !s.isEmpty());
    }


    public static boolean isIncludeAllChars(String word, Set<Character> characterSet) {

        int [] array = new int[28];

        word.chars().forEach(a -> array[a-'a']++);

        return characterSet.stream()
                .filter(i -> array[i - 'a'] == 0)
                .collect(Collectors.toList())
                .isEmpty();

    }
}
