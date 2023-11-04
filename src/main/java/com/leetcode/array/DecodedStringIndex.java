package com.leetcode.array;

public class DecodedStringIndex {

    public static void main(String[] args) {
        System.out.println(new DecodedStringIndex().decodeAtIndex("leet2code3",10));
        System.out.println(new DecodedStringIndex().decodeAtIndex("ha22",5));
        System.out.println(new DecodedStringIndex().decodeAtIndex("a2345678999999999999999",5));
    }

    public String decodeAtIndex(String s, int k) {

        //leet2code3
        //leet if k=4,8,12 then character always be t size=4 4%4,8%4,12%4=0 so if mod is 0 answer we ll get
        //if k=3 and if size=3, then k%3=0 so 3 would be answer , here we index=1 , so last value mod 0 is answer
        //leet2code3 at 13th we have 3 so leetleetcode3 at 13 answer will be l, we can get right answer if k%size is 0
        //if not reduce side 13%48 no 0, so 13%(48/3) 13%12 no 0...at last 13%1==0 so answer is l
        //leet2 at k=5 answer will be l,size is 8 leetleet at 5=l, if you found number reduce the size

        long size=0;

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);

            int a=c;
            if(a>(int)'0' && a<=(int)'9'){
                size*=(a-'0');
            }else {
                size++;
            }
        }

        for (int i = s.length()-1; i >-1 ; i--  ) {
            char c=s.charAt(i);
            int a=c;
            k %= size;
            if(k==0 && a>=((int)'a') && a<=(int)'z'){
                return c+"";
            }

            if(a>(int)'0' && a<=(int)'9'){
                 size/=(c-'0');
            }else {

                    size--;

            }
        }

        throw  null;
    }
}
