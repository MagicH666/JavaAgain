package com.magic;


import java.util.*;

public class MapDemo {


    public static void main(String[] args) {
        // 随机类
        Random random = new Random();
        String emptyString = "";
        // 100万样本数
        int size = 1000000;
        // 一次只测试一个实现类
        //Map<String, String> map = new HashMap<>();
        //Map<String, String> map = new TreeMap<>();
        Map<String, String> map = new LinkedHashMap<>();

        // 顺序插入
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            map.put(i + emptyString, i + emptyString);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(map.getClass() + "插入" + size + "个元素共耗时： " + (endTime - startTime) + "ms");

        // 随机获取
        startTime = System.currentTimeMillis();
        String valueStr = "";
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(map.size());
            valueStr = map.get(randomInt + emptyString);
        }
        endTime = System.currentTimeMillis();
        System.out.println(map.getClass() + "随机读取一万次耗时： " + (endTime - startTime) + "ms");

        // 随机删除
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(map.size());
            map.remove(randomInt + emptyString);
        }
        endTime = System.currentTimeMillis();
        System.out.println(map.getClass() + "随机删除一万个耗时： " + (endTime - startTime) + "ms");

        // 转化keySet
        startTime = System.currentTimeMillis();
        Set<String> stringSet = map.keySet();
        endTime = System.currentTimeMillis();
        System.out.println(map.getClass() + "转化keySet耗时： " + (endTime - startTime) + "ms");

        // 转化values
        startTime = System.currentTimeMillis();
        Collection<String> values = map.values();
        endTime = System.currentTimeMillis();
        System.out.println(map.getClass() + "转化values耗时： " + (endTime - startTime) + "ms");


    }
}
