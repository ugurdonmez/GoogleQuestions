package sorting.merge_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ugurdonmez on 29/07/16.
 */

/*
 google-interview-questions

Given two object arrays of "id,weight" (sorted by weight),
merge them together and create a one single array.
If the "id"s are same values should be merged.
Final resulting array should be sorted by weight.
Result should be O(nlogn) in time complexity.
 */

public class Solution {

    public Obj [] mergeObjArray(Obj [] array1, Obj [] array2) {

        List<Obj> results = new ArrayList<>();

        Arrays.sort(array1, new SortById());
        Arrays.sort(array2, new SortById());

        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1].id == array2[index2].id) {
                results.add(new Obj(array1[index1].id, array1[index1].weight + array2[index2].weight));
                index1++;
                index2++;
            } else if (array1[index1].id < array2[index2].id) {
                results.add(new Obj(array1[index1].id, array1[index1].weight));
                index1++;
            } else {
                results.add(new Obj(array2[index2].id, array2[index2].weight));
                index2++;
            }
        }

        while (index1 < array1.length) {
            results.add(new Obj(array1[index1].id, array1[index1].weight));
            index1++;
        }

        while (index2 < array2.length) {
            results.add(new Obj(array2[index2].id, array2[index2].weight));
            index2++;
        }

        Arrays.sort(array1, new SortByWeight());
        Arrays.sort(array2, new SortByWeight());

        Obj [] resultArray = (Obj [])results.toArray();

        Arrays.sort(resultArray, new SortByWeight());

        return resultArray;
    }

}

class Obj {
    final int id;
    int weight;

    public Obj(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}

class SortById implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(((Obj) o1).id, ((Obj) o2).id);
    }
}

class SortByWeight implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(((Obj) o1).weight, ((Obj) o2).weight);
    }
}
