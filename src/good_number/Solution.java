package good_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 30/07/16.
 */
public class Solution {


    public static void main(String [] args) {

        printGoodNumbers(1000000);

    }


    public static boolean isGoodNumber(int number, List<Integer> cubes) {

        int ways = 0;

        for (int i = 0; i < cubes.size(); i++) {
            for (int j = i+1; j < cubes.size(); j++) {
                if (cubes.get(i) + cubes.get(j) == number) {
                    ways++;
                    if (ways == 2) {
                        return true;
                    }
                }
                if (cubes.get(i) + cubes.get(j) > number) {
                    break;
                }
            }
        }

        return false;
    }

    public static void printGoodNumbers(int limit) {

        List<Integer> cubes = new ArrayList<>();

        int i = 1;
        int cube = 1;
        while (cube <= limit) {
            cubes.add(cube);
            i++;
            cube = i * i * i;
        }

        for (int l = 1; l < limit; l++) {
            if (isGoodNumber(l, cubes)) {
                System.out.println(l);
            }
        }

    }

}
