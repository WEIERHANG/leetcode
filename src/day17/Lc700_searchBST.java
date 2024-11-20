package day17;


/**
 * 700. 二叉搜索树中的搜索
 *
 */
public class Lc700_searchBST {

    public static Node searchBST(Node root, int target){
        if(root == null || root.v == target) return root;

        //如果要搜索的值要是 小于 跟节点的值 说明要搜索的值 在左子树
        //反之 在右子树
        if(target < root.v) return searchBST(root.l, target);
        else return searchBST(root.r, target);

    }


}
