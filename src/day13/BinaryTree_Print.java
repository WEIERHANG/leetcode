package day13;

import java.util.*;

/**
 * 二叉树的递归便利
 */
public class BinaryTree_Print {

    // 前序便利.....
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        prePrint(root, res);
        return res;
    }
    // lc144---前序便利 跟左右
    public void prePrint(Node root, List<Integer> res) {
        if(root == null) return;
        res.add(root.v);
        prePrint(root.l, res);
        prePrint(root.r, res);
    }
    // lc94----中序遍历  左跟右
    public void midPrint(Node root, List<Integer> res) {
        if(root == null) return;
        midPrint(root.l, res);
        res.add(root.v);
        midPrint(root.r, res);
    }
    // lc145---- 后续便利  左右跟
    public void postPrint(Node root, List<Integer> res) {
        if(root == null) return;
        postPrint(root.l, res);
        postPrint(root.r, res);
        res.add(root.v);
    }

}
