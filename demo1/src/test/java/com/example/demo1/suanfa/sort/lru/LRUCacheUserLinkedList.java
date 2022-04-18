package com.example.demo1.suanfa.sort.lru;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheUserLinkedList extends LinkedList {

    /**
     * 为什么用哪个map可以快速查看元素是否存在。时间复杂度o(1)
     */
    private HashMap<Integer, Integer> map;
    private int capacity = 3;

    public LRUCacheUserLinkedList(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }


    /**
     * 新增元素放到头部，淘汰尾部
     * <p>
     * 查看元素是否存在，存在-》 删除原来的，移动到头部
     * 不存在-》 看容量：
     * -》容量不足，删除尾部，添加元素
     * -》容量够，添加元素头部
     *
     * @param
     * @return
     */
    public boolean put(Integer value) {
        if (map.containsKey(value)) {
            remove(value);
            addFirst(value);
            return true;
        }
        if (map.size() >= capacity) {
            Integer deleteKey = (Integer) removeLast();
            map.remove(deleteKey);

            addFirst(value);
            map.put(value, value);
        } else {
            map.put(value, value);
            addFirst(value);
        }

        return true;
    }


    public Integer get1(Integer key) {
        if (map.containsKey(key)) {
            remove(key);
            addFirst(key);
            return map.get(key);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LRUCacheUserLinkedList list = new LRUCacheUserLinkedList(4);
        list.put(1);
        list.put(2);
        list.put(3);
        list.put(4);
        list.put(5);
        list.put(6);
        list.put(7);

        list.put(1);
        list.get1(6);


//        list.map.forEach((key,value)->{
//            System.out.println(key);
//        });


        list.iterator().forEachRemaining(s->{
            System.out.println(s);
        });
    }
}
