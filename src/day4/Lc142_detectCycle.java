package day4;

import day3.Node;

public class Lc142_detectCycle {

    public Node detectCycle(Node head) {
        Node f = head, s = head;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(f == s){
                Node index1 = f, index2 = head;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;

    }


    public static void main(String[] args) {

    }
}
