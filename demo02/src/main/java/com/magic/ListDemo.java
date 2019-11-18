package com.magic;


import java.util.*;

public class ListDemo {


    public static void main(String[] args) {
        // 一次只测试一个实现类
        //List<Integer> list = new ArrayList<>();
        //List<Integer> list = new Vector<>();
        List<Integer> list = new LinkedList<>();


        test(list);

    }

    /**
     * 入口
     *
     * @param list
     */
    public static void test(List<Integer> list) {
        testAddTime(list, 1000000);
        testIndexUpTime(list);
        testForEachTime(list);
        testIteratorTime(list);
        testIndexDownTime(list);
        testReadRandomTime(list);
        testRandomDelTime(list);
        testRandomAddTime(list);
        testRandomSetTime(list);
    }

    /**
     * 顺序添加测试
     *
     * @param list
     */
    public static void testAddTime(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "插入" + size + "个元素共耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * 迭代器遍历测试
     *
     * @param list
     */
    public static void testIteratorTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer integer = it.next();
            // 空遍历
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "迭代器遍历耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * ForEach遍历测试
     *
     * @param list
     */
    public static void testForEachTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (Integer i : list) {
            // 空遍历
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "ForEach遍历耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * 索引递增遍历测试
     *
     * @param list
     */
    public static void testIndexUpTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            // 空循环
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "递增索引遍历耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * 索引递减遍历测试
     *
     * @param list
     */
    public static void testIndexDownTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = list.size() - 1; i > 0; i--) {
            // 空循环
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "递减索引遍历耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * 随机读取测试
     *
     * @param list
     */
    public static void testReadRandomTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        Integer integer = 0;
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            integer = list.get(randomInt);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机读取一万次耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * 随机删除测试
     *
     * @param list
     */
    public static void testRandomDelTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            list.remove(randomInt);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机删除一万个元素耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * 随机插入对象
     * @param list
     */
    public static void testRandomAddTime(List<Integer> list){
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            list.add(randomInt,randomInt);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机插入一万个元素耗时： " + (endTime - startTime) + "ms");
    }

    /**
     * 随机更改对象
     * @param list
     */
    public static void testRandomSetTime(List<Integer> list){
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            list.set(randomInt,randomInt);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass() + "随机更改一万个元素耗时： " + (endTime - startTime) + "ms");
    }

}
