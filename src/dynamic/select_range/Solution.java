package dynamic.select_range;

import common.trie.Trie;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ugurdonmez on 31/07/16.
 */

/*
google-interview-questions

You are given a range [first, last], initially white. You need to paint it black.
For this purpose you have a set of triples
[(f, l, cost), ...] - where each triple means that you can paint range [f, l] for
`cost` coins (limitations: cost is floating point >= 0, f, l, first, last are integers).
Find minimum cost needed to paint the whole range [first, last] or return -1 if it's impossible
Example:

[first, last] = [0, 5] and set of triples is
[[0, 5, 10], [0, 4, 1], [0, 2,5], [2, 5, 1]]

Clearly the answer is to take [0, 4, 1] and [2, 5, 1] - the total cost will be 2.
Another example:

[first, last] = [0, 5]
triples are [[1,4, 10], [2, 5, 6]]

answer is -1, because it's impossible to color whole range.
*/

public class Solution {

    public static void main(String [] args) {

        Triples t1 = new Triples(0, 5, 10);
        Triples t2 = new Triples(0, 4, 1);
        Triples t3 = new Triples(0, 2, 5);
        Triples t4 = new Triples(2, 5, 1);

        Triples [] array = {t1, t2, t3, t4};

        System.out.println(getCost(0, 5, array));
    }

    public static int getCost(int start, int end, Triples [] array) {

        int sum = 0;
        int index = 0;

        Arrays.sort(array);

        while (index <= end) {
            boolean found = false;

            for (int i = 0; i < array.length; i++) {
                if (array[i].isInclude(index)) {
                    sum += array[i].cost;
                    index = array[i].end + 1;
                    found = true;
                    break;
                }
            }

            if (!found) {
                return -1;
            }
        }

        return sum;
    }
}

class Triples implements Comparable<Triples> {

    final int start;
    final int end;
    final int cost;

    public Triples(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Triples o) {

        if (this.cost == o.cost) {
            return Integer.compare(this.start, o.end);
        }

        return Integer.compare(this.cost, o.cost);

    }

    public boolean isInclude(int index) {
        return index <= this.end && index >= this.start;
    }
}
