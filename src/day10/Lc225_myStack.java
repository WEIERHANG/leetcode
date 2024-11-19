package day10;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 */
public class Lc225_myStack {
    Queue<Integer> q;

    public Lc225_myStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        rePosistion();
        return q.poll();

    }
    public int top() {
        rePosistion();
        int res = q.poll();
        q.add(res);
        return res;
    }

    public boolean empty() {
        return q.isEmpty();
    }
    private void rePosistion() {
        int size = q.size();
        size--;
        //只要 size 仍然大于 0，就继续循环，同时在每次循环中 size 会减 1。
        while (size-- > 0) q.add(q.poll());
    }

}
