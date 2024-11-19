package day14;

/**
 *101. 对称二叉树
 */
public class Lc101_isSymmetric {

    public boolean isSymmetric(Node root) {

        return comport(root.l, root.r);
    }

    private boolean comport(Node l, Node r) {
        //终止条件
        if(l == null && r != null) return false;
        if(l != null && r == null) return false;
        if(l == null && r == null) return true;
        if(l.v != r.v) return false;
        // 处理逻辑 外侧: 左的左 比较 右的右   内: 左的右  比较  右的左
        boolean outSide = comport(l.l, r.r);
        boolean inSide = comport(l.r, r.r);
        return outSide && inSide;
    }


    public static void main(String[] args) {

    }
}
