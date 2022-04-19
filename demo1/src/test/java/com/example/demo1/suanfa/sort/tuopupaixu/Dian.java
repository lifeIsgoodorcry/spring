package com.example.demo1.suanfa.sort.tuopupaixu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dian {
    int value; //值
    int in;
    int out;
    Map nodes = new HashMap<Integer, Dian>();
    Set bian = new HashSet<Dian>();

    public Dian() {
        this.nodes = new HashMap<Integer, Dian>();
        this.bian = new HashSet<Dian>();
    }
}
