package day16;


import java.util.*;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 */
public class Lc106_buildTree {

    Map<Integer, Integer> m;  //用来快速定位中序遍历中节点的索引位置。

    public Node buildTree(int[] in, int[] post) {
        m = new HashMap<>();

        //用map保存中序序列的数值对应的位置
        for(int i = 0; i < in.length; i++) m.put(in[i], i);

        return findNode(in, 0, in.length, post, 0, post.length);

    }

    public Node findNode(int[] in, int inBegin, int inEnd, int[] post, int postBegin, int postEnd) {
        //左闭右开  如果不满足 说明是空的
        if(inBegin >= inEnd || postBegin >= postEnd) return null;
        // 后续数组的最后一个元素 就是根节点 然后构造出来
        int rootIndex = m.get(post[postEnd - 1]);
        Node root = new Node(in[rootIndex]);
        // 保存中序的左子树个数, 确定后续数组的个数
        int lLength = rootIndex - inBegin;

        root.l = findNode(in, inBegin, rootIndex, post, postBegin, postBegin + lLength);

        root.r = findNode(in, rootIndex + 1, inEnd, post, postBegin + lLength, postEnd - 1);

        return root;

    }


}
