package com.example.demo1.suanfa.sort.tuopupaixu;

import java.util.*;

public class Dian {
    int value; //值
    int in;
    int out;
    List<Dian> nodes;
    List<Dian>  bians;

    public Dian(int value) {
        this.nodes = new ArrayList<>();
        this.bians = new ArrayList<>();
        this.value=value;
        in=0;
        out=0;
    }
}
