package day6;


import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的
 * 交集
 *  。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 */
public class Lc349_intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        // 便利数组1
        for(int i : nums1) s1.add(i);

        //便利数组2的过程中需要判断hash表中是否存在该元素
        for(int i : nums2){
            if(s1.contains(i)) res.add(i);
        }
        // 另外申请一个数组存放res集合中的元素并且返回
        int[] arr = new int[res.size()];
        int index = 0;
        for(int num : res) arr[index++] = num;
        return arr;
    }



}
