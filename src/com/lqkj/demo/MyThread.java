package com.lqkj.demo;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author ZTC
 * @Date 2019/12/19 14:59
 * @Version 1.0
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("ztc" + Thread.currentThread().getName());
    }
}
