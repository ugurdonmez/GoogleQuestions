package string.is_iterleave;

import java.util.Scanner;

/**
 * Created by ugurdonmez on 03/11/16.
 */
public class Solution {

    public static void main(String [] args) {

        //System.out.println(isInterLeave("a", "b", "ab"));
        //System.out.println(isInterLeave("abc", "", "abc"));

        //System.out.println(isInterLeave("aab", "axy", "aaxaby"));

        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        for (int i = 0; i < test; i++) {
            String a = scanner.next();
            String b = scanner.next();
            String c = scanner.next();

            if (isInterLeave(a, b, c)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }

    public static boolean isInterLeave(String a,String b,String c) {

        if (c.equals("")) {
            return true;
        }

        if (a.equals("")) {
            return c.equals(b);
        }

        if (b.equals("")) {
            return c.equals(a);
        }

        if (a.charAt(0) == c.charAt(0) && b.charAt(0) == c.charAt(0)) {
            return isInterLeave(a.substring(1, a.length()), b, c.substring(1, c.length())) ||
                    isInterLeave(a, b.substring(1, b.length()), c.substring(1, c.length()));
        }

        if (a.charAt(0) == c.charAt(0)) {
            return isInterLeave(a.substring(1, a.length()), b, c.substring(1, c.length()));
        }

        if (b.charAt(0) == c.charAt(0)) {
            return isInterLeave(a, b.substring(1, b.length()), c.substring(1, c.length()));
        }

        return false;
    }

}
