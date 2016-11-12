package matrix.celebrity;

import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 03/11/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [][] matrix = {{0,1,0},{0,0,0},{0,1,0}};

        System.out.println(getID(matrix, 3));

    }

    public static boolean isAllZero(int [][] matrix, int i) {

        return IntStream.of(matrix[i])
                .filter(c -> c == 1)
                .count() == 0;

    }

    public static int getID(int [][] matrix, int n) {

        for (int i = 0; i < n; i++) {
            if (isAllZero(matrix, i)) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (matrix[j][i] == 0) {
                        return -1;
                    }
                }
                return i;
            }
        }

        return -1;
    }
}
