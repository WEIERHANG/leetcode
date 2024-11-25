package day18;


/**
 * 236. 二叉树的最近公共祖先 -- 中等
 *  给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Lc236_lowestCommonAncestor {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        if(root == null || root == p || root == q) return root;

        Node left = lowestCommonAncestor(root.l,p,q);
        Node right = lowestCommonAncestor(root.r, p, q);

        if(left == null && right == null) return null;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return root;

    }







    public static void main(String[] args) {

    }




}
