package magic;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo04
 * @description: volatile与原子性
 * @author: Magic.H
 * @create: 2019-11-27 19:21
 **/
public class App03 {
    // 假设有一个施工公司在盖房子，他将派出10个施工队来盖100层
    // 当前楼层
    private volatile static int count = 0;
    // 盖100层楼
    private final static int sum = 100;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            // 施工队
            new Thread(() -> {
                while (count < sum) {
                    System.out.println(Thread.currentThread().getName() + "盖了第" + (++count) + "层");
                    // 盖累了休息2秒钟
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "worker"+i).start();
        }
    }
}
