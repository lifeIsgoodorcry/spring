package com.example.demo1.thread.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue延迟队列，需要存放队列的元素实现Delayed接口，重写比较器
 */
public class O1 {

    static class Task implements Delayed{
        long time;
        String name;
        public Task(long time, String name) {
            this.time = time;
            this.name = name;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            long l = unit.convert(time-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
            return l;
        }
        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Task> queue = new DelayQueue<>();
        long currentTimeMillis = System.currentTimeMillis();
        queue.add(new Task(currentTimeMillis + 1000, "task1"));
        queue.add(new Task(currentTimeMillis + 2000, "task2"));

        while (!queue.isEmpty()){
            Task task = queue.take();
            System.out.println(task.name);
        }
    }



}
