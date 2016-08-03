package combination.print_all_combination;

/**
 * Created by ugurdonmez on 31/07/16.
 */

/*

 google-interview-questions

Given k - which is the number of bits, print all the possible combinations
of numbers formed by printing all numbers with one bit set, followed by two bits set, ...
up to the point when all k-bits are set. They must be sorted according to the number of bits set,
if two numbers have the same number of bits set then they should be placed as per their value.

For example if K=3
Output:
000, 001, 010, 100,101, 110, 011, 111
0 bits set, followed by 1 bits set followed by 2 bits set followed by 3 bits set.

 */

public class Solution {

    public static void main(String [] args) {

        printK(4);

        System.out.println();

        printK(5);

    }

    public static void printK(int k) {
        for (int i = 0; i <= k; i++) {
            printPrefix("", i, k);
        }
    }

    public static void printPrefix(String prefix, int one, int length) {

        if (one == 0) {
            System.out.print(prefix);
            for (int i = 0; i < length; i++) {
                System.out.print("0");
            }
            System.out.println();
        } else if (one == length) {
            System.out.print(prefix);
            for (int i = 0; i < length; i++) {
                System.out.print("1");
            }
            System.out.println();
        } else if (length > one) {
            String newPrefix = prefix + "0";
            printPrefix(newPrefix, one, length-1);

            newPrefix = prefix + "1";
            printPrefix(newPrefix, one-1, length-1);
        }
    }
}
