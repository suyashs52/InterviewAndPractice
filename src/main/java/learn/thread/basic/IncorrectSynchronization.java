package learn.thread.basic;


class IncorrectSynchronization {
    public static void main(String args[]) throws InterruptedException {
        IncorrectSynchronization.runExample();
    }

    Boolean flag = Boolean.valueOf(true);

    public void example() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                //The object the first thread synchronized on before going to sleep has been changed,
                // and now it is attempting to call wait() on an entirely different object without having synchronized on it.
                synchronized (flag) {
                    try {
                        while (flag) {
                            System.out.println("First thread about to sleep "+flag);
                            Thread.sleep(5000);
                          //  flag.wait();
                            System.out.println("After thread 1 sleep value "+flag);
                            System.out.println("Woke up and about to invoke wait() "+flag);
                          //  flag.wait();
                        }
                    } catch (Exception ie) {
                        Thread.interrupted();

                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {

                    flag = false;
                 //   flag.notify();
                    System.out.println("Boolean assignment done."+flag);




            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
    }

    public static void runExample() throws InterruptedException {
        IncorrectSynchronization incorrectSynchronization = new IncorrectSynchronization();
        incorrectSynchronization.example();
    }
}
