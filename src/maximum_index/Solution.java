package maximum_index;

import java.util.Scanner;

/**
 * Created by ugurdonmez on 20/11/16.
 */
public class Solution {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        for (int i = 0; i < test; i++) {
            int n = scanner.nextInt();

            int [] array = new int[n];

            for (int j = 0 ; j < n; j++) {
                array[j] = scanner.nextInt();
            }

            System.out.println(maximumIndex(array));
        }

    }

    public static int maximumIndex(int[] array) {



        return 0;
    }

}
