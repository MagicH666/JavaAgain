package magic;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo03
 * @description: 测试入口
 * @author: Magic.H
 * @create: 2019-11-25 11:41
 **/
public class App {

    private static int index = 1;
    private static final int MAX = 5000;

    public static void main(String[] args) {
        App app = new App();
        // 模拟五个线程在访问
        for (int i = 0; i < 5; i++) {
            // 线程不安全
            //new Thread(app::normal).start();

            // 修饰代码块
            // new Thread(app::block).start();
            // 修饰方法
            // new Thread(app::method).start();
            // 修饰类
            // new Thread(app::clazz).start();
            // 查看阻塞
            new Thread(app::block2).start();
        }

    }

    /**
     * 线程不安全情况下
     */
    public void normal() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + " is running , index is " + index++);
        }
    }

    /**
     * 修饰代码块
     */
    public void block() {
        synchronized (this) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread().getName() + " is running , index is " + index++);
            }
        }
    }

    /**
     * 修饰代码块（查看阻塞）
     */
    public void block2() {
        synchronized (this) {
            while (index <= MAX) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " is running , index is " + index++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 修饰方法
     */
    public synchronized void method() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + " is running , index is " + index++);
        }
    }



    /**
     * 修饰类
     */
    public void clazz() {
        synchronized (App.class) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread().getName() + " is running , index is " + index++);
            }
        }
    }
}
