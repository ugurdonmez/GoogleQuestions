package string.trie_string_matching;

import common.trie.Trie;

/**
 * Created by ugurdonmez on 30/07/16.
 */
public class Solution {

    public static void main(String [] args) {

        String [] dict = {"ugur", "donmez", "google", "facebook", "microsoft", "oracle", "abc", "def"};

        String key = "ugurdefasdasdacasdonmezoracle";

        Trie trie = new Trie();

        for (int i =0; i < dict.length; i++) {
            trie.addWord(dict[i]);
        }

    }

}
