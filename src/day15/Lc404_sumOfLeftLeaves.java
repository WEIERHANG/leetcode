package day15;


/**
 * 404. 左叶子之和
 *
 */
public class Lc404_sumOfLeftLeaves {

    public int sumOfLeftLeaves(Node root) {

        if(root == null) return 0;
        // 左 右 跟
        int l = sumOfLeftLeaves(root.l);
        int r = sumOfLeftLeaves(root.r);

        int mid = 0;
        if(root.l != null && root.l.l == null && root.l.r == null) mid = root.l.v;

        return mid + l + r;


    }

    public static void main(String[] args) {

    }
}
