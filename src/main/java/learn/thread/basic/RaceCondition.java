package learn.thread.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


class RaceCondition {
    public static void main(String args[]) throws InterruptedException {
        RaceCondition.runTest();
    }
    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {

        int i = 1000000;
        while (i != 0) {
            if (randInt % 5 == 0) { //in-between same and below line that the value of randInt is
                // modified by the modifier thread! so print value not divisible by 5 This is what constitutes a race condition.
                //  synchronized(this) can be used after while(i!=0)
                if (randInt % 5 != 0) //
                    System.out.println(randInt);
            }
            i--;
        }
    }

    void modifier() {

        int i = 1000000;
        while (i != 0) {   //  synchronized(this) can be used after while(i!=0) 
            randInt = random.nextInt(1000);
            i--;
        }
    }


    public String[] findRelativeRanks(int[] score) {
        int[][] newArray = new int[score.length][2];

        for (int i = 0; i < score.length; i++) {
            newArray[i][0] = score[0];
            newArray[i][1] = i;

        }

        Arrays.sort(newArray, Comparator.comparingInt(a -> a[0]));

        String[] ans = new String[score.length];
        String[] tag = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < 3; i++) {
            ans[newArray[i][1]] = tag[i];
        }

        for (int i = 3; i < newArray.length; i++) {
            ans[newArray[i][1]] = "" + i;
        }

        return ans;


    }

    public static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
