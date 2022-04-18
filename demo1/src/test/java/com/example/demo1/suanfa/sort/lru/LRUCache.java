package com.example.demo1.suanfa.sort.lru;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, Integer> map;

    DubboNodeList nodeList;
    int capacity = 10;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        nodeList = new DubboNodeList();
        this.capacity = capacity;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);

        cache.nodeList.iter();
        cache.put(4,4);
        cache.nodeList.iter();
    }
    /**
     * 添加元素：元素不存在：  如果空间够，直接添加到map,元素添加到链表头部。
     * 空间不够，删除尾部元素，添加改元素到head
     * 元素存在：删除当前节点，添加到头部链表
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = new Node(key, value);
            nodeList.delete(node);
            //移动到头结点
            nodeList.addHead(node);
            return;
        }

        //满了
        if (map.size() == capacity) {
            //需要删除元素
            int deleteKey = nodeList.deleteTail();
            map.remove(deleteKey);
            //添加元素
            Node node = new Node(key, value);
            nodeList.addHead(node);
            map.put(key, value);
        } else {
            //没有满
            Node node = new Node(key, value);
            nodeList.addHead(node);
            map.put(key, value);
        }
    }

    public Integer get(int key) {
        Integer value = map.get(key);
        //删除元素，再添加到头
        Node node = new Node(key, value);
        nodeList.delete(node);
        nodeList.addHead(node);
        return value;
    }

}
