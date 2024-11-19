package day3;

public class Lc203_removeElements {

    public static Node removeElements(Node head, int v){
        Node tempNode = new Node();
        tempNode.next = head;
        Node cur = tempNode;
        while (cur.next != null){
            if(cur.next.val == v) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return tempNode.next;
    }

    public static void main(String[] args) {

    }

}
