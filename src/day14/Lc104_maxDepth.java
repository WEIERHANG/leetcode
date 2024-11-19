package day14;


/**
 * 104.二叉树的最大深度 给定一个二叉树，找出其最大深度。
 */
public class Lc104_maxDepth {


    // 使用后续便利 左右跟
    public int maxDepth(Node root){
        if(root == null) return 0;

        int lDepth = maxDepth(root.l);
        int rDepth = maxDepth(root.r);
        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {

    }


}
