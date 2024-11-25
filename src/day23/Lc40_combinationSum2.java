package day23;

import java.util.*;

/**
 *
 */
public class Lc40_combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, res, path, 0);
        return res;
    }
    private void backTracking(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> path, int sum) {
        if (sum == target) {
            // 如果路径的和等于目标值，保存当前路径
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 去重：跳过同一树层中相同的数字
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // 选择当前数字
            sum += candidates[i];
            path.add(candidates[i]);

            backTracking(candidates, target, i + 1, res, path, sum);

            // 回溯，撤销选择
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        // 测试用例
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        // 创建 Lc40_combinationSum2 实例
        Lc40_combinationSum2 solution = new Lc40_combinationSum2();

        // 调用方法并输出结果
        List<List<Integer>> result = solution.combinationSum2(candidates, target);

        // 打印结果
        System.out.println("结果:");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}