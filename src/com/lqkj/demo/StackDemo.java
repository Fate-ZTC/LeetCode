package com.lqkj.demo;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author ZTC
 * @Date 2020/1/3 10:01
 * @Version 1.0
 **/
public class StackDemo {
    private int maxSize;
    private int[] stackArr;
    private int top = -1;
    /*
     *构造方法
     */
    public StackDemo(int maxSize) {
        this.maxSize = maxSize;
        stackArr = new int[maxSize];
    }
    /*
     *查看栈顶元素
     */
    public int peek() {
        return stackArr[top];
    }
    /*
     *是否栈满
     */
    public boolean isFull() {
        if(top == maxSize -1) {
            return true;
        }else {
            return false;
        }
    }
    /*
     *是否栈空
     */
    public boolean empty() {
        if(top == -1) {
            return true;
        }else {
            return false;
        }
    }
    /*
     *入栈
     */
    public void push(int temp) {
        //判断栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }else {
            top ++;
            stackArr[top] = temp;
        }
    }
    /*
     *出栈
     */
    public int pop() {
        //判断栈空
        if (empty()) {
            throw new RuntimeException("栈空，无数据!");
        }else {
            int value = (char)stackArr[top];
            top --;
            return value;
        }
    }
    /*
     *遍历栈
     */
    public void list() {
        if (empty()) {
            System.out.println("栈空,无数据!");
        }else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d] = %s\n",i,(char)stackArr[i]);
            }
        }
    }
    /*
     *运算符的优先级,数字越大优先级别越高
     */
    public int prionrity(int oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        }else if(oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;//现在只有加减乘除
        }
    }
    /*
     *判断是不是一个运算符
     */
    public boolean isOper(char val) {
        return val =='+' || val == '-' || val == '*' ||val == '/';
    }
    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }
    public static void main(String[] args) {
        //数栈
        StackDemo numberStck = new StackDemo(10);
        StackDemo exStack = new StackDemo(10);
        String express = "7*3+5*2";
        char[] chars = express.toCharArray();
        //将表达式扫描入栈
        for (int i = 0; i < chars.length; i++) {
            boolean oper = numberStck.isOper(chars[i]);
            if (oper) {
                //将当前的运算符与栈顶的运算符进行比较，如果当前运算符的优先级高于栈顶元素或者当前栈为空,直接入栈，否者从数字栈直接弹出两个数字进行计算，将计算结果直接加入数字栈
                if (exStack.empty() || exStack.prionrity(chars[i]) >= exStack.prionrity(exStack.peek())) {
                    exStack.push(chars[i]);
                } else {
                    int num1 = numberStck.pop();
                    int num2 = numberStck.pop();
                    int oper1 = exStack.pop();
                    numberStck.push(numberStck.cal(num1, num2, oper1));
                    exStack.push(chars[i]);
                }
            }else {
                numberStck.push(chars[i] - 48);
            }
        }
        while(true) {
            if (exStack.empty()) {
                break;
            }
            int num3 = numberStck.pop();
            int num4 = numberStck.pop();
            int oper = exStack.pop();
            int res = numberStck.cal(num3, num4, oper);
            numberStck.push(res);
        }
        System.out.printf("计算的结果为:%d", numberStck.pop());
    }
}
