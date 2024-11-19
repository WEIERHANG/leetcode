package day16;


/**
 * lc112 路径和
 */
public class Lc112_hasPathSum {


    public boolean hasPathSum(Node root, int targetSum) {

        if(root == null) return false;

        targetSum -= root.v;

        if(root.l == null && root.r == null) return targetSum == 0;

        if(root.l != null){
            boolean lv = hasPathSum(root.l, targetSum);
            if(lv) return true;
        }
        if(root.r != null){
            boolean rv = hasPathSum(root.r, targetSum);
            if(rv) return true;
        }
        return false;

    }
}
