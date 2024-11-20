package day17;


/**
 * 98. 验证二叉搜索树--中等
 *
 */
public class Lc98_isValidBST {
    Node max;


    public boolean isValidBST(Node root) {
        if(root == null) return true;

        //左
        boolean left = isValidBST(root.l);
        //跟
        if(max != null && root.v <= max.v) return false;
        max = root;
        //右
        boolean right = isValidBST(root.r);

        return right;

    }


    public static void main(String[] args) {

    }
}
