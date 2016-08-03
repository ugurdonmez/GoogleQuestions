package sorting.move_at_most_k_times;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ugurdonmez on 31/07/16.
 */

/*

 google-interview-questions

Given an array of length N and an integer K, sort the array as much as
possible such that no element travels more than k positions to its
left - an element however can travel as much as it likes to its right.

 */

public class Solution {

    public static void main(String [] args) {

        int [] array = {20,4,3,2,1,7,8,0};

        System.out.println(Arrays.toString(array));

        sort(array, 2);

        System.out.println(Arrays.toString(array));


        int [] array1 = {5,40,20,4,3,2,1,7,8,0};

        System.out.println(Arrays.toString(array1));

        sortOptimized(array1, 3);

        System.out.println(Arrays.toString(array1));

    }

    public static void sortOptimized(int [] array, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k+1);

        for (int i = 0; i <= k; i++) {
            priorityQueue.add(array[i]);
        }

        int index = 0;
        for (int i = k+1; i < array.length; i++) {
            array[index++] = priorityQueue.poll();
            priorityQueue.add(array[i]);
        }

        while (!priorityQueue.isEmpty()) {
            array[index++] = priorityQueue.poll();
        }

    }

    public static void sort(int [] array, int k) {

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j+1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

}
