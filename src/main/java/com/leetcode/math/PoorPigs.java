package com.leetcode.math;

public class PoorPigs {

    //https://leetcode.com/problems/poor-pigs/description/

    public static void main(String[] args) {
        int buckets = 4, minutesToDie = 15, minutesToTest = 15;
        System.out.println(new PoorPigs().poorPigs(buckets,minutesToDie,minutesToTest));

    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //total test or trail
        //if minutesToDie/minutesToTest wrong becuase we evaluated die before so can have an answer
        //total max trail for a pig we can simulate by minutesToTest/minutesToDie
        //if minutesToTest < minutesToDie then we cant find an answer that is right becuase we will have 0 trial
        //minutesToTest==minutesToDie means we can test bucket , for n=4 , if we choose pig=4 we can find our answer
        // but that is max case , we can max perform 1 trail on each pig and pig can drink any number of buckets
        //pig=1 for trial 1 can take 2 bucket 1,1 , pig drink 1 bucket if die 1 is poisionous other another bucket
        //so with pig =1 we can detect 2 bucket max for trail 1, if trail =2 we can use same pig in 2 trail
        //buckets are 3 pig =1 will be answer drink 1, if die no issue got the answer, if not die in 2nd trail drink
        //2nd and leave 3rd if die then 2nd, otherwise 3rd so in 2 trail , 3 bucket will need 1 pig only
        // 1pig can answer _, _,_  3 bucket for 2 trail
        // 2 pig can answer ---,---,--- 9 buckets for 2 trail
        //1 pig can drink entire rows, 1 pig can drink entire column buckets intersection will be the answer
        //3 pig can answer ---,---,--- 27 bucket for 2 trail(x,y,z)
        //so trail+1, for (trail+1)^x=Max bucket for 27 bucket , trail is 2 (3)^3=27 10 to 27 for trail 2 can be answerd by 3 pigs

        int trail=minutesToTest/minutesToDie;
        trail++; //for pig 1 , trail 1 we will always have 2 opportunity(take bucket /leave it),
        // for 2 pigs and 1 trail __,__ , for 2 pigs and 2 trails
        //each pig can navigate ___ bucket
        int x=0;

        while(((int)Math.pow(trail,x))<buckets) //for trail 2
        {
            x++;
        }
        return x;

        ///trail^x<bucket=> xlog(trail)<log(bucket)=> x<log(bucket)/log(trail) so is just greater then log/log run the loop
        //till then so x= Math.ceil(log(bucket)/log(trail))



    }
}
