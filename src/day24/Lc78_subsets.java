package day24;

import java.util.*;

/**
 * lc 78_ 子集问题
 *
 */
public class Lc78_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, res, path);
        return res;
    }

    private void backtracking(int[] nums, int sIndex, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = sIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
//    -----------------------

    // 对数器测试
    public static void main(String[] args) {
        Lc78_subsets solution = new Lc78_subsets();
        boolean allTestsPass = true;

        for (int test = 0; test < 1000; test++) { // 运行 1000 次随机测试
            int[] nums = generateRandomArray();
            List<List<Integer>> myResult = solution.subsets(nums);
            List<List<Integer>> expectedResult = bruteForceSubsets(nums);

            if (!areEqual(myResult, expectedResult)) {
                allTestsPass = false;
                System.out.println("Test failed for input: " + Arrays.toString(nums));
                System.out.println("Expected: " + expectedResult);
                System.out.println("Got: " + myResult);
                break;
            }
        }

        if (allTestsPass) {
            System.out.println("全部通过!");
        }
    }

    // 暴力解法
    private static List<List<Integer>> bruteForceSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n 个子集
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // 判断第 j 位是否为 1
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        return res;
    }

    // 随机生成数组
    private static int[] generateRandomArray() {
        Random random = new Random();
        int size = random.nextInt(6) + 1; // 数组大小 1 ~ 6
        int[] nums = new int[size];
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int val;
            do {
                val = random.nextInt(21) - 10; // 元素范围 -10 ~ 10
            } while (used.contains(val));
            nums[i] = val;
            used.add(val);
        }
        return nums;
    }

    // 比较两个子集列表是否相等
    private static boolean areEqual(List<List<Integer>> list1, List<List<Integer>> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        Set<Set<Integer>> set1 = new HashSet<>();
        Set<Set<Integer>> set2 = new HashSet<>();
        for (List<Integer> l : list1) {
            set1.add(new HashSet<>(l));
        }
        for (List<Integer> l : list2) {
            set2.add(new HashSet<>(l));
        }
        return set1.equals(set2);
    }
}
