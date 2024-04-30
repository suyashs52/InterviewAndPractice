package com.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

public class NoOfWonderfulSubstring {

    public static void main(String[] args) {
        System.out.println(new NoOfWonderfulSubstring().wonderfulSubstrings("abbaaac"));
    }

    public long wonderfulSubstrings(String word) {
        //a==1, b==2, c==4,d==8 ..j=2^10 so that 11111111..if all are unique
        // a b b a a a c
        //mask the char 1 to 10
        // 1. all no appear even no of times
        // 2. one no appear odd no of time
        // return no of non empty substring
        // empty string has all no appear even/empty time so 0,1
        // a (0 index) xor is 1 , not present in map so all number are not even times put 0,1 | 1,1
        // b(1) xor of 001^010=011 (3) not present in map, so all no are not event put 0,1 | 1,1 | 3,1
        // b(2) xor of 011^010 =001 this is present in map (for a) we again get xor value (1^(a^a^b^b)=1)
        //it means after 1 all number are even so substring form from those number add into our answer
        //(b,b) is our answer result+=1 (map.get(1)) not inscrese count in map 0,1 |1,2 | 3,1 , result=1
        //a(3) xor is 001^001=0 ,0 present in map, so again got even no of string, result+=map.get(0), (a b b a) 0,2 | 1,2 | 3,1 ,result=2
        //a(4) xor is 0^001=001, result += get(1) value: 2    0,2 | 1,3 | 3,1 , result=4
        //a(5) xor is 001^001=0  result+=get(0) result=4 , (a,b,b,a,a,a),(a,a) from a  0,3 | 1,3 | 3,1 , result=6
        //total even no: (b b )  (a b b a)  (a a) ( b b a a) (a a) (a b b a a a)
        //   0 1 2 3 4 5 6
        // 0 a b b a a a c
        // 0 1 3 1 0 1 0 4 --xor
        // first b b even no of b appeared 1 time so xor of a =1 it again reappear it means in b/w we got all even nos
        // excluding a, number of substring having even number is : count of that char in map
        // let talk on last xor 1, it appears at b so got all even no after b (a,a) , also 1 appear at index 0
        // so got all even no from index 1 (b b a a) so +2 add in result --> that is the count of all 1 in map before 1 xor of a(5)

        Map<Integer, Integer> xorFreq = new HashMap<>();
        xorFreq.put(0, 1);
        long ans = 0;
        int xor = 0;
        for (int i = 0; i < word.length(); i++) {
            int bit = word.charAt(i) - 'a';
            xor = xor ^ (1 << bit);
            ans += xorFreq.getOrDefault(xor, 0);


            //0 a b b
            //0 1 3 1 --xor
            // exactly 1 char has odd count,
            // do xor with element a--j (1,10 )
            //support at index 2, we do xor with a 1^1=0 and 0 in the map, after 0 their must be odd count of a
            //thats why xoring with a makes the xor value present in map (a b b) so add this in result
            //do with b 001^010=011 3 ,we must have odd b after index where xor last become 3 yes single b after index 1,
            // if a b b b xor is 1 3 1 3

            for (int j = 0; j < 10; j++) {
                int bit1 = 1 << j;
                int newMask = xor ^ bit1;
                if (xorFreq.containsKey(newMask)) {
                    ans += xorFreq.get(newMask);
                }
            }

            xorFreq.put(xor, xorFreq.getOrDefault(xor, 0) + 1);

        }

        return ans;
    }
}
