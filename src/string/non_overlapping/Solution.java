package string.non_overlapping;

/**
 * Created by ugurdonmez on 31/07/16.
 */
public class Solution {

    public static void main(String [] args) {
        printNonOverlapping("1234");

        System.out.println();
        System.out.println();

        printNonOverlapping("1111");

        System.out.println();
        System.out.println();

        printNonOverlapping("123456789");
    }

    public static void printNonOverlapping(String number) {
        printNonOverlapping("", number);
    }

    public static void printNonOverlapping(String prefix, String number) {
        System.out.println(prefix + "(" + number + ")");

        for (int i = 1; i < number.length(); i++) {
            String newPrefix = prefix + "(" + number.substring(0, i) + ")";
            printNonOverlapping(newPrefix, number.substring(i, number.length()));
        }
    }
}
