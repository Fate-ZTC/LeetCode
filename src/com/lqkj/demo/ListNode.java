package com.lqkj.demo;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/18 17:38
 * @Version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
