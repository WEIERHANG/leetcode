package day14;



/**
 * 111.二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 */
public class Lc111_minDepth {

    public int minDepth(Node root) {
        if(root == null) return 0;

        int lDepth = minDepth(root.l);
        int rDepth = minDepth(root.r);

        if(root.l == null) return rDepth + 1;
        if(root.r == null) return lDepth + 1;

        return Math.min(lDepth,rDepth) + 1;


    }


    public static void main(String[] args) {

    }
}
