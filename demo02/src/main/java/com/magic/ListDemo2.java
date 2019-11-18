package com.magic;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListDemo2 {


    public static void main(String[] args) {
        // 一次只测试一个实现类
        //List<Integer> list = new ArrayList<>();
        //List<Integer> list = new Vector<>();
        List<Integer> list = new LinkedList<>();
        int size = 1000000;
        Random random = new Random();
        //顺序添加测试
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "插入" + size + "个元素共耗时： " + (endTime - startTime) + "ms");
        // 迭代器遍历测试
        startTime = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer integer = it.next();
            // 空遍历
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "迭代器遍历耗时： " + (endTime - startTime) + "ms");

        //ForEach遍历测试
        startTime = System.currentTimeMillis();
        for (Integer i : list) {
            // 空遍历
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "ForEach遍历耗时： " + (endTime - startTime) + "ms");

        // 索引递增遍历测试
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            // 空循环
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "递增索引遍历耗时： " + (endTime - startTime) + "ms");

        // 索引递减遍历测试
        startTime = System.currentTimeMillis();
        for (int i = list.size() - 1; i > 0; i--) {
            // 空循环
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "递减索引遍历耗时： " + (endTime - startTime) + "ms");

        // 随机读取测试
        startTime = System.currentTimeMillis();
        Integer integer = 0;
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            integer = list.get(randomInt);
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机读取一万次耗时： " + (endTime - startTime) + "ms");

        // 随机删除测试
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            list.remove(randomInt);
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机删除一万个元素耗时： " + (endTime - startTime) + "ms");

        // 随机插入对象
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            list.add(randomInt, randomInt);
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机插入一万个元素耗时： " + (endTime - startTime) + "ms");

        // 随机更改对象
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            list.set(randomInt, randomInt);
        }
        endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机更改一万个元素耗时： " + (endTime - startTime) + "ms");

    }

}
