package day24;

import java.util.*;

/**
 * lc90 --- 子集II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 *
 * 给你的数组里面有 重复的 但是 你返回的结果集 不能重复
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class Lc90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, path, res);
        return res;
    }

    private void backtracking(int[] nums, int sIndex, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        if (sIndex >= nums.length) return;
        for (int i = sIndex; i < nums.length; i++) {
            if (i > sIndex && nums[i - 1] == nums[i]) continue;
            path.add(nums[i]);
            backtracking(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    // 测试方法
    public static void main(String[] args) {
        Lc90_subsetsWithDup solution = new Lc90_subsetsWithDup();

        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);

        System.out.println("输入: " + Arrays.toString(nums));
        System.out.println("输出: " + result);
    }
}
