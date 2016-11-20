package finding_the_numbers_gfg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ugurdonmez on 19/11/16.
 */
public class Solution {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        for (int i = 0; i < test; i++) {
            int size = scanner.nextInt();
            int [] array = new int[size*2+2];

            for (int j = 0; j < size*2+2; j++) {
                array[j] = scanner.nextInt();
            }

            ResultNumbers result = getNumbers(array, size);
            System.out.println(result.x + " " + result.y);
        }

    }

    public static ResultNumbers getNumbers(int[] array, int size) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        ResultNumbers resultNumbers = new ResultNumbers();
        boolean first = true;

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();

            if (entry.getValue() == 1) {
                if (first) {
                    resultNumbers.x = entry.getKey();
                    first = false;
                } else {
                    resultNumbers.y = entry.getKey();
                }
            }
        }

        int x = resultNumbers.x;
        int y = resultNumbers.y;

        resultNumbers.x = Integer.min(x, y);
        resultNumbers.y = Integer.max(x, y);

        return resultNumbers;
    }

}

class ResultNumbers {

    public int x;
    public int y;

}