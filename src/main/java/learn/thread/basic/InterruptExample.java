package learn.thread.basic;


class InterruptExample {

    public static void main(String args[]) throws InterruptedException {
        InterruptExample.example();
    }

    static public void example() throws InterruptedException {

          Thread sleepyThread = new Thread(new Runnable() {

            public void run() {
                try {
                    System.out.println("I am too sleepy... Let me sleep for an hour.");
                   // Thread.currentThread().interrupt();
                    Thread.sleep(1000 * 60 * 60);
                } catch (InterruptedException ie) {
                    System.out.println("The interrupt flag is cleard : " + Thread.interrupted() + " " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    Thread.currentThread().interrupt();
                    Thread.currentThread().interrupt();

                    System.out.println("Oh someone woke me up ! ");
                    System.out.println("The interrupt flag is set now : " + Thread.currentThread().isInterrupted() + " " + Thread.interrupted());

                }
            }
        });

        sleepyThread.start();

        System.out.println("About to wake up the sleepy thread ...");
        sleepyThread.interrupt(); //intrrupt the thread
      //  Thread.currentThread().interrupt();

        System.out.println("Woke up sleepy thread ...");

         sleepyThread.join();
        System.out.println("exit..");
    }
}