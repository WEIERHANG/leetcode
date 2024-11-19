package day4;


import day3.Node;

/**
 * lc24. 两两交换链表中的节点 中等
 *
 */
public class Lc24_swapPairs {
    public static Node swapPairs(Node head) {
        // 虚拟头结点
        Node dumpHead = new Node(-1);
        dumpHead.next = head;
        Node cur = dumpHead;
        Node temp, firstNode, secondNode;
        while (cur.next != null && cur.next.next != null){
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {

    }
}
