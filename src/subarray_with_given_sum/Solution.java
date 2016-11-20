package subarray_with_given_sum;

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
            int sum = scanner.nextInt();

            int [] array = new int[n];

            for (int j = 0 ; j < n; j++) {
                array[j] = scanner.nextInt();
            }

            ResultTwoNumber result = subarray(array, sum);

            if (result.x == -1) {
                System.out.println(-1);
            } else {
                System.out.println(result.x + " " + result.y);
            }
        }

    }

    public static ResultTwoNumber subarray(int [] array, int sum) {

        ResultTwoNumber result = new ResultTwoNumber();

        int i = 0;
        int j = 0;
        int currentSum = 0;

        while (j <= array.length) {
            if (currentSum < sum) {
                currentSum += array[j];
                j++;
            } else if (currentSum > sum) {
                currentSum -= array[i];
                i++;
            }

            if (sum == currentSum) {
                result.x = i+1;
                result.y = j;
                break;
            }

            if (currentSum < sum && j == array.length) {
                result.x = -1;
                break;
            }
        }

        return result;
    }


}

class ResultTwoNumber {
    int x;
    int y;
}
