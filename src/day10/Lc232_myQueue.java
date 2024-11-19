package day10;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 */
public class Lc232_myQueue {
    Stack<Integer> sIn, sOut;

    public Lc232_myQueue() {
        sIn = new Stack<>();  //进栈
        sOut = new Stack<>(); //出栈

    }

    public void push(int x) {
        sIn.push(x);
    }
    public int pop() {
        dumpStackIn();
        return sOut.pop();

    }

    public int peek() {
        dumpStackIn();
        return sOut.peek();

    }

    public boolean empty() {
        return sIn.isEmpty() && sOut.isEmpty();
    }
//    如果出栈为空 那么就将In中的元素全部放入Out里面
    private void dumpStackIn() {
        if(!sOut.isEmpty()) return;
        while (!sIn.isEmpty()) sOut.push(sIn.pop());
    }


    public static void main(String[] args) {
        Lc232_myQueue queue = new Lc232_myQueue();

        // 测试 push 操作
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("After push(1), push(2), push(3):");

        // 测试 peek 操作
        System.out.println("peek() = " + queue.peek()); // 应该返回 1

        // 测试 pop 操作
        System.out.println("pop() = " + queue.pop());   // 应该返回 1
        System.out.println("pop() = " + queue.pop());   // 应该返回 2

        // 测试 empty 操作
        System.out.println("empty() = " + queue.empty()); // 应该返回 false

        // 再次测试 peek 操作
        System.out.println("peek() = " + queue.peek());   // 应该返回 3

        // 测试 pop 直到队列为空
        System.out.println("pop() = " + queue.pop());     // 应该返回 3
        System.out.println("empty() = " + queue.empty()); // 应该返回 true
    }


}
