package learn.thread.basic;

class Demonstration {

    public static void main(String args[]) {
        Deadlock deadlock = new Deadlock();
        try {
            deadlock.runTest();
        } catch (InterruptedException ie) {
        }
    }
}

class Deadlock {

    private int counter = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    Runnable incrementer = new Runnable() {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    incrementCounter();
                    System.out.println("Incrementing " + i);
                    System.out.println("Counter Thread 1 =>" + counter);
                }
            } catch (InterruptedException ie) {
            }
        }
    };

    Runnable decrementer = new Runnable() {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    decrementCounter();
                    System.out.println("Decrementing " + i);
                    System.out.println("Counter Thread 2 =>" + counter);

                }
            } catch (InterruptedException ie) {
            }

        }
    };

    public void runTest() throws InterruptedException {

        Thread thread1 = new Thread(incrementer);
        Thread thread2 = new Thread(decrementer);

        thread1.start();
        // sleep to make sure thread 1 gets a chance to acquire lock1
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Done : " + counter);
    }

    void incrementCounter() throws InterruptedException {
        synchronized (lock1) { //make a lock on 1 object
            System.out.println("Acquired lock1 by incrementCounter");
            Thread.sleep(100); //sleep

            synchronized (lock2) {
                counter++;
            }
        }
    }

    void decrementCounter() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("Acquired lock2 by decrementCounter");
            //thread 1 make lock on object 1 in incrementCounter,  sleep for 100ms, lock on object2 increment , print do again for i=1
            //again make a lock on object 1 for i =1 , sleep for 100ms , thread 2 make lock on object 2 in parallel in decrementCounter,
            // sleep for 100ms , thread2 try to make a lock on object 1, see object already locked and wait
            //after waking up thread1 try to make a lock on object 2, see object already locked then wait
            // both are waiting for each other to unlock and deadlock

            Thread.sleep(100);
            synchronized (lock1) {
                counter--;
            }
        }
    }
}
