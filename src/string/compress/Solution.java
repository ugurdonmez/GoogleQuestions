package string.compress;

/**
 * Created by ugurdonmez on 02/08/16.
 */

/*

 google-interview-questions

Given the following decoder, write the encoder. (The encoder should be written to compress whenever possible):

p14a8xkpq -> p14akkkkkkkkpq

(8xk gets decoded to kkkkkkkk. The only other requirement is that encodings be unambiguous)

Note that the String can have any possible ascii character

 */

public class Solution {

    public static void main(String [] args) {

        System.out.println(decode("p14akkkkkkkkpq"));

    }

    public static String decode(String string) {

        StringBuilder buf = new StringBuilder();

        int count = 1;
        char prev = string.charAt(0);

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == prev) {
                count++;
            } else {
                if (count > 3) {
                    buf.append(count).append('x').append(prev);
                } else {
                    for (int j = 0; j < count; j++) {
                        buf.append(prev);
                    }
                }
                count = 1;
                prev = string.charAt(i);
            }
        }

        if (count > 3) {
            buf.append(count).append('x').append(prev);
        } else {
            for (int j = 0; j < count; j++) {
                buf.append(prev);
            }
        }

        return buf.toString();
    }
}
