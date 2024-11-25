package day22;
import java.util.*;
/**
 * lc77- 组合问题  -- 中等
 *从 1 到 n 的数字中，选出 k 个数字的所有组合。
 *
 * 比如，给定 n = 4 和 k = 2
 * [    [1, 2],
 *   [1, 3],
 *   [1, 4],
 *   [2, 3],
 *   [2, 4],
 *   [3, 4]      ]
 */
public class Lc77_combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtracking(n, k, 1, res, path);
        return res;

    }
    private void backtracking(int n, int k, int sIndex, List<List<Integer>> res, List<Integer> path) {
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = sIndex; i <= n; i++){
            path.add(i);
            backtracking(n, k, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc77_combine solution = new Lc77_combine();

        // 测试参数
        int n = 4; // 从 1 到 n 的数字
        int k = 2; // 选出 k 个数字的组合

        // 调用 combine 方法
        List<List<Integer>> result = solution.combine(n, k);

        // 打印结果
        System.out.println("所有组合结果：");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }


}
