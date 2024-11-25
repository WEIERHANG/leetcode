package day18;


import java.util.ArrayList;

/**
 * lc501_.二叉搜索树中的众数
 */
public class Lc501_findMode {

    ArrayList<Integer> res; //结果
    int count, maxCount;  //当前出现频率， 最大频率
    Node pre;  //前一个节点


    public int[] findMode(Node root) {
        res = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findModeDiGui(root);
        // 转成结果数组并且返回
        int[] resArr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) resArr[i] = res.get(i);

        return resArr;

    }

    private void findModeDiGui(Node root) {
        if (root == null) return;
        // 左
        findModeDiGui(root.l);
        // 根
        int rootVal = root.v;
        if(pre == null || rootVal != pre.v) count = 1;
        else count++;
        if(count > maxCount){
            res.clear();
            res.add(rootVal);
            maxCount = count;
        }else if(count == maxCount) res.add(rootVal);
        pre = root;

        // 右
        findModeDiGui(root.r);



    }


}
