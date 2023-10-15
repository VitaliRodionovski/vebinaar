public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Main main = new Main();
        main.doWork(counter);
    }

    public void doWork(Counter counter) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Final count value: " + counter.getValue());
        }
    }