package day16;


import java.util.LinkedList;
import java.util.Queue;

/**
 * lc513. 找树左下角的值 中等
 *
 */
public class Lc513_findBottomLeftValue {

    // 定义全局变量
    int Deep = -1, value = 0;
    public int findBottomLeftValue(Node root) {
        value = root.v;
        findLeftValue(root, 0);
        return value;
    }
    private void findLeftValue(Node root, int deep) {
        if(root == null) return;
        if(root.l == null && root.r == null) {
            if(deep > Deep){
                value = root.v;
                Deep = deep;
            }
        }
        if(root.l != null) findLeftValue(root.l, deep + 1);
        if(root.r != null) findLeftValue(root.r, deep + 1);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public int findBottomLeftValueII(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node poll = q.poll();
                if(i == 0) res = poll.v;
                if(poll.l != null) q.offer(poll.l);
                if(poll.r != null) q.offer(poll.r);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
