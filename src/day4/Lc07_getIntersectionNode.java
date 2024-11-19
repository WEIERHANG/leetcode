package day4;

import day3.Node;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 * ---------
 * 当两个指针遍历完自己的链表之后，在切换到对方的链表继续遍历。
 * 只要相遇，那一定是在交点相遇。如果没有交点，那就在 null 相遇。
 *
 */
public class Lc07_getIntersectionNode {
    public Node getIntersectionNode(Node headA, Node headB) {
        Node indexA = headA, indexB = headB;
        while (indexA != indexB){
            if(indexA == null) indexA = headB;
            else indexA = indexA.next;
            if(indexB == null) indexB = headA;
            else indexB = indexB.next;
        }
        return indexA;
    }

    public static void main(String[] args) {

    }
}
