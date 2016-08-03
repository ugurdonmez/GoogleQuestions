package pramp.array_of_array_product;

import java.util.*;

/**
 * Created by ugurdonmez on 30/07/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {2,7,3,4};

        System.out.println(Arrays.toString(getArrayOfArrayProduct(array)));

    }

    public static int [] getArrayOfArrayProduct(int [] array) {

        Map<Integer, Integer> map = new HashMap<>();

        int productUp = 1;
        map.put(array.length-1, productUp);

        for (int i = array.length-1; i > 0; i--) {
            productUp *= array[i];
            map.put(i-1, productUp);
        }

        int [] result = new int[array.length];
        int productDown = 1;

        for (int i = 0; i < array.length; i++) {
            result[i] = productDown * map.get(i);
            productDown *= array[i];
        }

        return result;
    }

}
