package day14;

/**
 * 二叉树节点
 */
public class Node {
    int v;
    Node l;
    Node r;
    Node(){

    }
    Node(int v){
        this.v = v;
    }
    Node(int v, Node l, Node r){
        this.v = v;
        this.l = l;
        this.r = r;
    }
}
