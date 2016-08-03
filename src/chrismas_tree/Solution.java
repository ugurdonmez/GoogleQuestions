package chrismas_tree;

/**
 * Created by ugurdonmez on 30/07/16.
 */

/*
 google-interview-questions

Problem : Christmas Tree

Chirag is a boy. And his one and only dream is to meet Santa Claus.
He decided to decorate a Christmas tree for Santa on coming Christmas.
Chirag made an interesting Christmas tree that grows day by day.

The Christmas tree is comprised of the following

Parts
Stand

Each Part is further comprised of Branches. Branches are comprised of Leaves.

How the tree appears as a function of days should be understood.
Basis that print the tree as it appears on the given day.
Below are the rules that govern how the tree appears on a given day.
Write a program to generate such a Christmas tree whose input is number of days.

Rules:

If tree is one day old you cannot grow. Print a message "You cannot generate christmas tree"

Tree will die after 20 days; it should give a message "Tree is no more"

Tree will have one part less than the number of days.
E.g.
On 2nd day tree will have 1 part and one stand.
On 3rd day tree will have 2 parts and one stand
On 4th day tree will have 3 parts and one stand and so on.
Top-most part will be the widest and bottom-most part will be the narrowest.
Difference in number of branches between top-most and second from top will be 2
Difference in number of branches between second from top and bottom-most part will be 1

Below is an illustration of how the tree looks like on 4th day
https://s31.postimg.org/5s1txk4zf/christmas_tree.jpg
https://s32.postimg.org/i2c6i850l/christmas_tree_2.jpg
 */

public class Solution {

    public static void main(String [] args) {

        printTree(4);

        System.out.println();
        System.out.println();
        System.out.println();

        printTree(10);

        System.out.println();
        System.out.println();
        System.out.println();

        printTree(20);

        System.out.println();
        System.out.println();
        System.out.println();

        printTree(25);
        printTree(1);

    }

    public static void printTree(int day) {
        if (day  < 2) {
            System.out.println("You cannot generate christmas tree");
            return;
        }

        if (day > 20) {
            System.out.println("Tree is no more");
            return;
        }

        StringBuilder buf = new StringBuilder();

        // first level
        for (int i = 1, j = day; i <= day*2 + 1; i = i+2, j-- ) {
            // space
            for (int a = 0; a <= j; a++) {
                buf.append(' ');
            }

            // star
            for (int a = 0; a < i; a++) {
                buf.append('*');
            }

            buf.append('\n');
        }

        for (int b = 1; b < day-1; b++) {

            for (int i = 3, j = day-1; i <= day*2 + 1 - b*2; i = i+2, j-- ) {
                // space
                for (int a = 0; a <= j; a++) {
                    buf.append(' ');
                }

                // star
                for (int a = 0; a < i; a++) {
                    buf.append('*');
                }

                buf.append('\n');
            }

        }

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i <= day; i++) {
                buf.append(' ');
            }
            buf.append('*').append('\n');
        }


        System.out.println(buf.toString());
    }

}
