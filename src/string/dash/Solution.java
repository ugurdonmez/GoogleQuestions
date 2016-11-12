package string.dash;

/**
 * Created by ugurdonmez on 28/10/16.
 */

/**
 *  google-interview-questions

 Given a string "2-4a0r7-4k", there are two dashes which we can split into 3 groups of length 1, 5, 2.

 If we want each group to be length 4, then we get "24A0-R74k"

 Given a String A and an int K, return a correctly formatted string.

 IF A is "2-4A0r7-4k" and B is 4, string is "24A0-R74K"
 IF K is 3, string is "24-A0R-74K" as the first grp could be shorter.
 */

public class Solution {

    public static void main(String [] args) {

        System.out.println(addDashes("2-4A0r7-4k", 2));
        System.out.println(addDashes("2-4A0r7-4k", 3));

    }

    public static String addDashes(String str, int k) {

        if (str.equals("")) {
            return str;
        }

        StringBuilder buf = new StringBuilder();

        /*
        str.chars()
                .filter(c -> c != '-')
                .boxed()
                .forEach(buf::append);
        */

        for (char c : str.toCharArray()) {
            if (c != '-') {
                buf.append(c);
            }
        }

        int length = buf.length() / k;
        int dif = (buf.length() - length * k);

        int index = 0;
        StringBuilder buf2 = new StringBuilder();

        for (int i = 0; i < k; i++) {

            int size = i > k - dif ? length + 1: length;

            for (int j = 0; j < size; j++) {
                buf2.append(buf.charAt(index));
                index++;
            }

            if (i != k-1) {
                buf2.append('-');
            }
        }

        return buf2.toString();
    }


}
