package day3;


/**
 * 翻转单链表
 *
 */
public class reverseNode {


    public static Node reverse(Node head){
        Node pre = null, next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {

    }


}
