package com.example.demo1.suanfa.sort.lru;


/**
 * 节点对象
 */
public class Node {
    int value;
    int key;
    Node pre;
    Node next;

    public Node(int key,int value) {
        this.key = key;
        this.value = value;
    }
}
