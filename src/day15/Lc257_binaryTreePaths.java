package day15;


import java.util.*;

/**
 * 257. 二叉树的所有路径
 *
 */
public class Lc257_binaryTreePaths {

    public List<String> binaryTreePaths(Node root) {
        List<String> res = new ArrayList<>();  //结果集
        List<Integer> path = new ArrayList<>();  //路径

        if(res == null) return res;

        traversal(root, path, res);
        return res;

    }

    private static void traversal(Node root, List<Integer> path, List<String> res) {
        // 根节点
        path.add(root.v);
        if(root.l == null && root.r == null){ //遇到叶子节点

            StringBuilder sb = new StringBuilder(); //拼接字符串
            for(int i = 0; i < path.size(); i++) sb.append(path.get(i)).append("->");

            sb.append(path.get(path.size() - 1));  //记录最后一个节点
            res.add(sb.toString());  //收集路径
            return;

        }
        // 左
        if(root.l != null) {
            traversal(root.l, path, res);
            path.remove(path.size() - 1); //回溯的过程
        }
        if(root.r != null){
            traversal(root.r, path, res);
            path.remove(path.size() - 1);
        }


    }


    public static void main(String[] args) {

    }


}
