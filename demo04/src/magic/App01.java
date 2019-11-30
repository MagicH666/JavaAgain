package magic;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo04
 * @description: 测试可见性
 * @author: Magic.H
 * @create: 2019-11-26 10:07
 **/
public class App01 {
    // 模拟施工和监工
    // 假设有一个人在盖房子，然后边上有一个人帮他数着，必须是盖一层，数一次，再接着盖一层
    // 当前楼层
    private static int count = 0;
    // 盖100层楼
    private final static int sum = 100;

    public static void main(String[] args) {
        // 施工
        new Thread(() -> {
            while (count < sum) {
                System.out.println("盖了第" + (++count) + "层");
                // 休息2秒钟让监工看一下
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "worker").start();

        // 监工
        new Thread(() -> {
            // 先将当前的楼层记下来
            int localValue = count;
            while (count < sum) {
                //int localValue = count;
                // 如果楼层发生变化
                if(localValue != count) {
                    System.out.println("确认盖了第" + count + "层");
                    localValue = count;
                }
            }
        }, "looker").start();
    }
}
