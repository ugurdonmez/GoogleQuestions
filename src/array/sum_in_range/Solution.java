package array.sum_in_range;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;

/**
 * Created by ugurdonmez on 03/08/16.
 */

/*

 google-interview-questions

Write a function that takes as input an array of integers A, and two integers low and high.

Your function has to output pairs of indices: {(i,j), ...}

Where each pair of indices denotes that the sub array of A[i...j] has a sum in the range low <= sum <= high.

Apparently there are algorithms better than O(N^2).

 */

public class Solution {

    public static void main(String [] args) {

        int [] array = {5,1,2,3,4,8,6,10};

        System.out.println(Arrays.toString(getInterval(array, 5, 10)));
    }

    public static Pair [] getInterval(int [] array, int low, int high) {

        ImmutableList.Builder<Pair> listBuilder = ImmutableList.builder();

        for (int i = 0; i < array.length; i++) {
            int sum = array[i];
            for (int j = i+1; j < array.length; j++) {
                sum += array[j];

                if (sum <= high && sum >= low) {
                    listBuilder.add(new Pair(i,j));
                }

                if (sum > high) {
                    break;
                }
            }
        }

        return listBuilder.build().toArray(new Pair[0]);
    }
}

class Pair {
    final int start;
    final int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}