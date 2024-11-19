package day4;

import java.util.Stack;

/**
 * 判断是否为回文链表
 * 1. 快慢指针找中点
 * 2. 将后半部分压入栈内
 * 3. 弹出一个就立马和前面对比 不一样就是false
 * 4. 最后返回true
 */
public class isHuiWenLiked {
    public boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;

        //找中点
        Node s = head, f = head;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        // 后半部分压栈
        Stack<Integer>  stack = new Stack<>();
        while (s != null){
            stack.push(s.val);
            s = s.next;
        }
        // 比较
        Node cur = head;
        while (!stack.isEmpty()){
            if(cur.val != stack.pop()) return false;
            cur = cur.next;
        }
        return true;

    }
    public static void main(String[] args) {
        isHuiWenLiked solution = new isHuiWenLiked();

        // 测试用例1：回文链表 1 -> 2 -> 2 -> 1
        Node head1 = new Node(1, new Node(2, new Node(2, new Node(1))));
        System.out.println("测试用例1：" + (solution.isPalindrome(head1) ? "是回文链表" : "不是回文链表"));

        // 测试用例2：非回文链表 1 -> 2 -> 3 -> 4
        Node head2 = new Node(1, new Node(2, new Node(3, new Node(4))));
        System.out.println("测试用例2：" + (solution.isPalindrome(head2) ? "是回文链表" : "不是回文链表"));

        // 测试用例3：回文链表 1 -> 2 -> 3 -> 2 -> 1
        Node head3 = new Node(1, new Node(2, new Node(3, new Node(2, new Node(1)))));
        System.out.println("测试用例3：" + (solution.isPalindrome(head3) ? "是回文链表" : "不是回文链表"));

        // 测试用例4：单节点链表 1 (回文链表)
        Node head4 = new Node(1);
        System.out.println("测试用例4：" + (solution.isPalindrome(head4) ? "是回文链表" : "不是回文链表"));

        // 测试用例5：空链表 (不是回文链表)
        Node head5 = null;
        System.out.println("测试用例5：" + (solution.isPalindrome(head5) ? "是回文链表" : "不是回文链表"));
    }


}
