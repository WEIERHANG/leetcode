package day7;

import java.util.*;

/**
 * 454. 四数相加 II 中等
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class Lc454_fourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        // 统计前两个数组中的元素之和并且统计次数
        // 如果sum存在map  返回 对应值(出现次数) 不在就默认返回0
        // 最后的加1是因为每当找到一个新的sum 说明多出现一次
        for(int i : nums1){
            for(int j : nums2){
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // 统计后俩
        for(int i : nums3){
            for (int j : nums4){
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
    // 暴力解法
    public int fourSumCountBruteForce(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                for (int k : nums3) {
                    for (int l : nums4) {
                        if (i + j + k + l == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Lc454_fourSumCount solution = new Lc454_fourSumCount();
        Random rand = new Random();
        boolean success = true;

        // 测试1000次
        for (int i = 0; i < 10000; i++) {
            int n = 5;  // 数组大小
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            int[] nums3 = new int[n];
            int[] nums4 = new int[n];

            // 随机填充数组
            for (int j = 0; j < n; j++) {
                nums1[j] = rand.nextInt(20) - 10;
                nums2[j] = rand.nextInt(20) - 10;
                nums3[j] = rand.nextInt(20) - 10;
                nums4[j] = rand.nextInt(20) - 10;
            }

            int resultOptimized = solution.fourSumCount(nums1, nums2, nums3, nums4);
            int resultBruteForce = solution.fourSumCountBruteForce(nums1, nums2, nums3, nums4);

            if (resultOptimized != resultBruteForce) {
                success = false;
                System.out.println("Test failed!");
                System.out.println("nums1: " + java.util.Arrays.toString(nums1));
                System.out.println("nums2: " + java.util.Arrays.toString(nums2));
                System.out.println("nums3: " + java.util.Arrays.toString(nums3));
                System.out.println("nums4: " + java.util.Arrays.toString(nums4));
                System.out.println("Optimized result: " + resultOptimized);
                System.out.println("Brute force result: " + resultBruteForce);
                break;
            }
        }

        if (success) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}