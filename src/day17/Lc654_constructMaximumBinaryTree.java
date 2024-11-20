package day17;


/**
 * 654. 最大二叉树
 *
 */
public class Lc654_constructMaximumBinaryTree {

    public Node constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        return digui(nums, 0, nums.length);

    }


    private Node digui(int[] nums, int lIndex, int rIndex) {
        if(rIndex - lIndex < 1) return null;  //小于一说明没有元素了

        if(rIndex - lIndex == 1) return new Node(nums[lIndex]); // 说明只有一个元素

        int maxIndex = lIndex; //假设最大值的下标
        int maxVal = nums[maxIndex]; //假设最大值
        for(int i = lIndex + 1; i < rIndex; i++){ // 找最大值
            if(nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;

            }
        }
        Node root = new Node(maxVal);  //根据最大值构造跟节点
        root.l = digui(nums, lIndex, maxIndex);
        root.r = digui(nums, maxIndex + 1, rIndex);
        return root;

    }


}
