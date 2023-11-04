package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbByNoOf1Bits {

    public static void main(String[] args) {
        System.out.println(new SortNumbByNoOf1Bits().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public int[] sortByBits(int[] arr) {

        List<Pairs> list = new ArrayList<>();


        for (int i : arr) {
            list.add(new Pairs(i, noOfBits(i)));
        }

        Collections.sort(list, (a, b) -> {
            if (a.bbb == b.bbb) {
                return a.aaa - b.aaa;
            } else return a.bbb - b.bbb;
        });


        int[] r = new int[arr.length];
        int i = 0;
        for (Pairs p : list) {
            r[i++] = p.aaa;
        }

        return r;
    }

    int noOfBits(int n) {
        int a = 10000;

        int b = 1;
        int count = 0;

        while (b <= a && b<=n) {
            if ((b & n) == b) {
                count++;
            }
            b = b << 1;
        }

//
//        while (num > 0) {
//            weight++;
//            num &= (num - 1);
//        }
        //num & num-1 will reduce least significant bit of num
        //111000 , num-1 will be 110111 so & is 110000
        //Logically, every bit to the right of the LSB(righteous 1 bit) will be 0.
        // That means when we subtract 1 from num, the LSB becomes 0 and every bit to the right of it becomes 1.

        return count;
    }

    static class Pairs {
        public Integer aaa;
        public Integer bbb;

        Pairs(int a, int b) {
            this.aaa = a;
            this.bbb = b;
        }

    }
}
