package day16;


import java.util.HashMap;
import java.util.Map;

/**
 * lc105_找到前序和中序 还原二叉树 返回根节点
 */
public class Lc105_buildTreeQz {

    Map<Integer, Integer> m;

    public Node buildTree(int[] pre, int[] mid) {
        m = new HashMap<>();

        for(int i = 0; i < mid.length; i++) m.put(mid[i],i);

        return findNodeII(pre,0,pre.length,mid,0,mid.length);

    }

    private Node findNodeII(int[] pre, int preB, int preE, int[] mid, int midB, int midE) {
        if(preB >= preE || midB >= midE) return null;

        int rootIndex = m.get(pre[preB]);
        Node root = new Node(mid[rootIndex]);

        int lLen = rootIndex - midB;

        root.l = findNodeII(pre, preB + 1,preB + lLen + 1, mid, midB, rootIndex);

        root.r = findNodeII(pre, preB + lLen + 1, preE, mid, rootIndex + 1, midE);

        return root;

    }
}
