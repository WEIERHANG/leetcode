package day18;


/**
 * 530. 二叉搜索树的最小绝对差  简单
 *  给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class Lc530_getMinimumDifference {

    Node pre;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(Node root) {
        if(root == null) return 0;

        diGui(root);
        return res;
    }

    private void diGui(Node root) {
        if(root == null) return;
        //左
        diGui(root.l);
        //跟
        if(pre != null) res = Math.min(res, root.v - pre.v);
        pre = root;
        // 又
        diGui(root.r);

    }

}
