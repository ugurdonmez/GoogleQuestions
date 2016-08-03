package integer.delete_consecutive_digits;

/**
 * Created by ugurdonmez on 31/07/16.
 */

/*

google-interview-questions

Write program that takes integer, deletes one of two consecutive digits and return greatest of all results.

Example:
Input Number: 1993487443
Output Number: 199348743
Here we have 2 consecutive duplicates 99 and 44.
Deleting one of the 4 would yield a greater result than deleting the 9. 199348743 vs 193487443

Another Example:
Input number:1100
Output Number: 110
Deleting the 0 would make the number larger than deleting the 1 would. 110 vs 100
*/

public class Solution {

    public static void main(String [] args) {

        System.out.println(deleteConsecutiveDigit(1100));

    }

    public static int deleteConsecutiveDigit(int value) {

        String str = String.valueOf(value);

        for (int i = str.length()-2; i >= 0; i--) {

            String first = str.substring(i, i+1);
            String second = str.substring(i+1, i+2);

            if (first.equals(second)) {
                str = str.substring(0, i) + str.substring(i+1, str.length());
                break;
            }
        }

        return Integer.valueOf(str);
    }

}
