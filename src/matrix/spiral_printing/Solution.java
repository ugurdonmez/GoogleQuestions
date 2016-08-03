package matrix.spiral_printing;

/**
 * Created by ugurdonmez on 30/07/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [][] matrix =  {{1,   2,   3,   4,   5},
                {6,   7,   8,   9,  10},
                {11,  12,  13,  14,  15},
                {16,  17,  18,  19,  20}};


        printSpiral(matrix);

    }

    public static void printSpiral(int [][] matrix) {

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        StringBuilder buf = new StringBuilder();

        while (top <= bottom && left <= right) {

            // print top
            for (int i = left; i <= right; i++) {
                buf.append(matrix[top][i]).append(' ');
            }
            top++;

            // print right
            for (int i = top; i <= bottom; i++) {
                buf.append(matrix[i][right]).append(' ');
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    buf.append(matrix[bottom][i]).append(' ');
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    buf.append(matrix[i][left]).append(' ');
                }
                left++;
            }
        }

        System.out.println(buf.toString());
    }

}
