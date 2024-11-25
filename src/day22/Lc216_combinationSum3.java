package day22;

import java.util.ArrayList;
import java.util.List;

/**
 * lc216--216. 组合总和 III  -- 中等
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 *
 */
public class Lc216_combinationSum3 {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(k, n, 1, 0, res, path);
        return res;

    }
    private void backtracking(int k, int n, int sIndex, int sum, List<List<Integer>> res, List<Integer> path) {
        if(sum > n) return;
        if(path.size() == k){
            if(sum == n) res.add(new ArrayList<>(path));
            return;
        }
        for(int i = sIndex; i <= 9; i++){
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1, sum, res, path);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        Lc216_combinationSum3 solution = new Lc216_combinationSum3();

        // 测试用例 1
        int k1 = 3, n1 = 7;
        System.out.println("输入: k = " + k1 + ", n = " + n1);
        List<List<Integer>> result1 = solution.combinationSum3(k1, n1);
        System.out.println("输出: " + result1);

        // 测试用例 2
        int k2 = 3, n2 = 9;
        System.out.println("输入: k = " + k2 + ", n = " + n2);
        List<List<Integer>> result2 = solution.combinationSum3(k2, n2);
        System.out.println("输出: " + result2);

        // 测试用例 3
        int k3 = 4, n3 = 1;
        System.out.println("输入: k = " + k3 + ", n = " + n3);
        List<List<Integer>> result3 = solution.combinationSum3(k3, n3);
        System.out.println("输出: " + result3);

        // 测试用例 4
        int k4 = 2, n4 = 5;
        System.out.println("输入: k = " + k4 + ", n = " + n4);
        List<List<Integer>> result4 = solution.combinationSum3(k4, n4);
        System.out.println("输出: " + result4);
    }
}
