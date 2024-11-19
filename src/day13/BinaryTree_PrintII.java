package day13;

import java.util.*;

/**
 * 使用压栈的方式 便利二叉树
 */
public class BinaryTree_PrintII {

//      先序遍历
    public List<Integer> prePrint(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            res.add(root.v);
            if (root.r != null) s.push(root.r);
            if (root.l != null) s.push(root.l);
        }
        return res;
    }

    // 在前序的基础上改成入栈顺序为先左再右  最后再来一个翻转
    public List<Integer> postPrint(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            root = s.pop();
            res.add(root.v);
            if(root.l != null) s.push(root.l);
            if(root.r != null) s.push(root.r);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> midPrint(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> s = new Stack<>();
        Node cur = root;
        while (cur != null && !s.isEmpty()){
            // 1. 遍历左子节点，将当前节点压入栈，并将 cur 移动到左子节点
            if(cur != null){
                s.push(cur);
                cur = cur.l;
            }else {
                // 2. 如果当前节点为空（说明已经到达左子树的尽头）
                // 从栈中弹出节点，访问该节点并将其值加入结果列表
                cur = s.pop();
                res.add(cur.v);
                // 3. 然后将 cur 移动到右子节点，继续对右子树进行相同操作
                cur = cur.r;
            }
        }
        return res;
    }


}
