package magic;

public class App2 extends Thread {
    private static int index = 1;
    private static final int MAX = 5000;

    @Override
    public void run() {
        synchronized (this) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread().getName() + " is running , index is " + index++);
            }
        }
    }

    public static void main(String[] args) {
        App2 t1 = new App2();
        App2 t2 = new App2();
        App2 t3 = new App2();
        App2 t4 = new App2();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
