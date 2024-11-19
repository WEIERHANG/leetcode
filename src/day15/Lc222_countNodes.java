package day15;

/**
 * lc222. 完全二叉树节点个数
 */
public class Lc222_countNodes {

    public int countNodes(Node root){
        if(root == null) return 0;

        return countNodes(root.l) + countNodes(root.r) + 1;
    }


    public static void main(String[] args) {

    }
}
