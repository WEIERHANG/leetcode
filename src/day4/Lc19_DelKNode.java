package day4;


import day3.Node;

public class Lc19_DelKNode {

    /**
     * 删除倒数第k节点
     * 1. 新建虚拟node 他的next指向头结点
     * 2. 快慢指针分别指向虚拟节点
     * 3. 快指针先走n+1步, 然后快慢在同时走 一直到快指针到头,此时慢指针就是倒数第k
     * --------
     * 让f移动n+1步 然后 f s同时移动 直到f指向链表的尾巴 删除s指的节点
     *
     *
     */
    public static Node removeNthFromEnd(Node head, int n) {
        // 1. 虚拟头结点
        Node temp = new Node(-1);
        temp.next = head;
        Node f = head, s = head;
        // 2. 快指针走n+1步
        for(int i = 0; i <= n; i++) f = f.next;
        // 3. 同时移动
        while(f != null){
            f = f.next;
            s = s.next;
        }
        // 4. 删除s 并且返回
        if(s.next != null) s.next = s.next.next;
        return temp.next;

    }

    // 打印链表的方法
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 测试 delKNode 方法
    public static void main(String[] args) {
        // 创建一个测试链表：1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("原始链表：");
        printList(head); // 打印原始链表

        // 测试删除倒数第 2 个节点
        int n = 2;
        head = removeNthFromEnd(head, n);

        System.out.println("删除倒数第 " + n + " 个节点后的链表：");
        printList(head); // 打印删除节点后的链表
    }

}
