package com.magic;


import java.util.*;

public class SetDemo {


    public static void main(String[] args) {
        // 随机类
        Random random = new Random();
        // 100万样本数
        int size = 1000000;
        // 一次只测试一个实现类
        //Set<Integer> set = new HashSet<>();
        //Set<Integer> set = new TreeSet<>();
        Set<Integer> set = new LinkedHashSet<>();

        // 顺序插入
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(set.getClass() + "插入" + size + "个元素共耗时： " + (endTime - startTime) + "ms");

        // 迭代器遍历
        startTime = System.currentTimeMillis();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            // 空遍历
            Integer integer = it.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println(set.getClass() + "迭代器遍历共耗时： " + (endTime - startTime) + "ms");

        // ForEach遍历
        startTime = System.currentTimeMillis();
        for (Integer i : set) {
            //空循环
        }
        endTime = System.currentTimeMillis();
        System.out.println(set.getClass() + "ForEach遍历共耗时： " + (endTime - startTime) + "ms");

        // 随机更新（set不重复，插入小的就是更新）
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(set.size());
            set.add(randomInt);
        }
        endTime = System.currentTimeMillis();
        System.out.println(set.getClass() + "随机更新10000个元素共耗时： " + (endTime - startTime) + "ms");

        // 随机删除
        startTime = System.currentTimeMillis();
        Integer integer = 0;
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(set.size());
            set.remove(randomInt);
        }
        endTime = System.currentTimeMillis();
        System.out.println(set.getClass() + "随机删除10000个元素共耗时： " + (endTime - startTime) + "ms");

    }


}
