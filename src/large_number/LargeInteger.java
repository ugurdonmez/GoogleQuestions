package large_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 28/07/16.
 */

/*
Write a class to take in a large arbitrary number,
also provide a function to increment the number.
The number will be passed on as an array of integers.
 */

public class LargeInteger {

    private List<Integer> number;

    public LargeInteger(int [] array) {
        this.number = new ArrayList<>();

        for (int i = array.length-1; i >= 0; i--) {
            this.number.add(array[i]);
        }
    }

    public void increment() {

        for (int i = 0; i < this.number.size(); i++) {
            if (this.number.get(i) < 9) {
                this.number.set(i, this.number.get(i) + 1);
                return;
            } else {
                this.number.set(i, 0);
            }
        }

        this.number.set(this.number.size()-1, 0);
        this.number.add(1);
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append("Large Integer").append('\n');

        for (int i = this.number.size()-1; i >= 0; i--) {
            buf.append(this.number.get(i));
        }

        return buf.toString();
    }
}
