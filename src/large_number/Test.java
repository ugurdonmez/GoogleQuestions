package large_number;

/**
 * Created by ugurdonmez on 28/07/16.
 */
public class Test {

    public static void main(String [] args) {

        int [] array = {1,2,3,4,5,6,7,4,3,5,7,1,3,5,7,5,1,3,4,5,5,6,6,7,9};

        LargeInteger largeInteger = new LargeInteger(array);

        System.out.println(largeInteger);
        largeInteger.increment();
        System.out.println(largeInteger);

        int [] a1 = {9,9,9,9};

        LargeInteger li1 = new LargeInteger(a1);

        System.out.println(li1);
        li1.increment();
        System.out.println(li1);
    }

}
