package com.example.demo1.suanfa.sort.tuopupaixu;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        //相当于申请一个map key为当前课程，value=set 为课程的下一项。
        int[][] prerequisites=new int[3][3];

        execute(prerequisites,0);
    }


    /**
     * @param prerequisites
     * @param nums          课程的数字，总数 比如2， 1 2 两门课程
     */
    public static int[] execute(int[][] prerequisites, int nums) {
        int[] result = new int[nums];
        int index = 0;

        System.out.println();

        Map<Integer, Dian> map =
                build1(prerequisites, nums);

        //循环所有课程，找出没有依赖的课程放入队列
        Queue<Dian> zeroQueue = new ArrayDeque<>();
        for (int i = 0; i < nums; i++) {
            Dian dian = map.get(i);
            if (dian.in == 0) {
                //说明没有依赖，可以独立完成，放到队列
                zeroQueue.add(dian);
            }
        }

        //从队列里面获取课程进行完成
        while (!zeroQueue.isEmpty()) {
            Dian dian = zeroQueue.poll();
            result[index] = dian.value;
            index++;
            //获取当前完成课程的依赖项,入度减1，检测到减1之后入度为0，进行加入队列
            List<Dian> list = dian.nodes;
            if (list.size() > 0) {
                for (Dian dian1 : list) {
                    dian1.in--;
                    if (dian1.in == 0) {
                        zeroQueue.add(dian1);
                    }
                }
            }
        }

        return result;

    }


    public static Map<Integer, Dian> build1(int[][] prerequisites, int nums) {
        Map<Integer, Dian> map = new HashMap<>();
        //点里面的nodes存的是next的集合
        for (int i = 1; i <= nums; i++) {
            //建点  [1,0]  先学0，在学1
            int to = prerequisites[i][0];
            if (map.get(to) == null) {
                //说明还没有加入，新建
                map.put(to, new Dian(to));
            }
            int from = prerequisites[i][1];
            if (map.get(from) == null) {
                map.put(from, new Dian(from));
            }
            //添加完成绑定关系
            Dian fromDian = map.get(from);
            Dian toDian = map.get(to);
            fromDian.nodes.add(toDian);
            toDian.in++; //入度加1  你的依赖关系。
        }

        return map;
    }

    public static void build(int[][] prerequisites, int nums) {
        Tu tu = new Tu();
        Map<Integer, Dian> dianMap = tu.nodes;
        tu.nodes = dianMap;
        Set<Dian> dianSet = tu.bian;
        tu.bian = dianSet;

        // [1,0]    [1,0]  先学0，在学1
        for (int i = 1; i <= nums; i++) {
            //建点
            int value = prerequisites[i][0];
            if (dianMap.get(value) == null) {
                //说明还没有加入，新建
                Dian dian = new Dian(value);
                dianMap.put(value, dian);
                //他的边
                int bian = prerequisites[i][1];
                if (dianMap.get(bian) == null) {
                    Dian n = new Dian(bian);
                    dianSet.add(n);
                } else {
                    dianSet.add(dianMap.get(bian));
                }
            }

        }
    }
}
