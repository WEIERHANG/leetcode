package day15;


/**
 * lc110 - 判断是否为平衡二叉树
 */
public class Lc110_isBalanced {
    
    public boolean isBalanced(Node root){
        return getH(root) != -1;
    }

    private int getH(Node root) {
        if(root == null) return 0;
// 左
        int lH = getH(root.l);
        if(lH == -1) return -1;
//  右
        int rH = getH(root.r);
        if(rH == -1) return -1;
//  跟 -- 如果左右高度相差1 那就不是
        if(Math.abs(lH - rH) > 1) return -1;
// 返回结果
        return Math.max(lH, rH) + 1;
    }


}
