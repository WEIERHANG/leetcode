package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前中后统一写法
 */
public class BinaryTree_PrintIII {


    /**
     * 统一模版写法
     *
     *
     */
    public List<Integer> xxxPrint(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        if(root != null) s.push(root);
        while (!s.isEmpty()){
            Node cur = s.peek();
            if(cur != null){
                s.pop();
//      ...      前便利:跟左右  入栈就是 右 左 跟 null
//      ...      中便利:左跟右  入栈就是 右 跟 null 左
//      ...      后便利:左右跟  入栈就是 跟 null 右 左

            }else {
                s.pop();
                cur = s.peek();
                s.pop();
                res.add(cur.v);
            }
        }
        return res;
    }

//      先序遍历
    public List<Integer> prePrint(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        if (root != null) s.push(root);
        while (!s.isEmpty()){
            Node cur = s.peek();
            if(cur != null){
                s.pop();
                if(cur.r != null) s.push(cur.r);
                if(cur.l != null) s.push(cur.l);
                s.push(cur);
                s.push(null);
            }else{
                s.pop();
                cur = s.peek();
                s.pop();
                res.add(cur.v);
            }
        }
        return res;
    }

    // 后
    public List<Integer> postPrint(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        if(root != null) s.push(root);
        while (!s.isEmpty()){
            Node cur = s.peek();
            if(cur != null){
                s.pop();
                s.push(cur);
                s.push(null);
                if(cur.l != null) s.push(cur.l);
                if(cur.r != null) s.push(cur.r);
            }else{
                s.pop();
                cur = s.peek();
                s.pop();
                res.add(cur.v);
            }
        }
        return res;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> midPrint(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        if (root != null) s.push(root);
        while (!s.isEmpty()){
            Node cur = s.peek();
            if(cur != null){
                s.pop();
                if(cur.r != null) s.push(cur.r);
                s.push(cur);
                s.push(null);
                if (cur.l != null) s.push(cur.l);
            }else {
                s.pop();
                cur = s.peek();
                s.pop();
                res.add(cur.v);
            }
        }

        return res;
    }


}
