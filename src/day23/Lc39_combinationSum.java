package day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lc39__组合总和 元素可以重复
 * 给你一个无重复元素的数组  和一个目标值 找出数组中所有可以使数字和为目标值的组合
 * 数组的数字可以无限制重复选取
 * 但是不能包含重复的组合
 *
 */
public class Lc39_combinationSum {

    public List<List<Integer>> combinationSum(int[] arr, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(arr);
        backtracking(arr,target,0,0,res,path);
        return res;

    }

    private void backtracking(int[] arr, int target, int sum, int sIndex, List<List<Integer>> res, List<Integer> path) {
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = sIndex; i < arr.length; i++){
            sum += arr[i];
            if(sum > target) break;
            path.add(arr[i]);
            backtracking(arr,target,sum,i,res,path);
            sum -= arr[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc39_combinationSum solution = new Lc39_combinationSum();

        // 测试输入
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        // 调用方法
        List<List<Integer>> result = solution.combinationSum(candidates, target);

        // 打印结果
        System.out.println("所有组合总和为 " + target + " 的组合：");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}