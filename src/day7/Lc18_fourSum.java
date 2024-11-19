package day7;


import java.util.*;

/**
 * lc18四数之和 中等 ....
 *
 *
 */
public class Lc18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序数组
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length; k++){
            // 剪枝
            if(nums[k] > target && nums[k] > 0) break;
            //去重
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            for(int i = k + 1; i < nums.length; i++){
                // 剪枝 去重i
                if(nums[k] + nums[i] > target && nums[k] + nums[i] >= 0) break;
                if(i > k + 1 && nums[i] == nums[i - 1]) continue;
                // l 和 r
                int l = i + 1, r = nums.length - 1;
                while (l < r){
                    long sum = nums[k] + nums[i] + nums[l] + nums[r];
                    if(sum > target) r--;
                    else if (sum < target) l++;
                    else {
                        res.add(Arrays.asList(nums[k],nums[i],nums[l],nums[r]));
                        // l 和 r去重
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        r--;
                        l++;
                    }
                }
            }

        }
        return res;
    }
    public static void main(String[] args) {
        Lc18_fourSum solution = new Lc18_fourSum();
        boolean isCorrect = true;
        int testCases = 1000;

        for (int i = 0; i < testCases; i++) {
            int[] nums = generateRandomArray(10, -50, 50);
            int target = (int) (Math.random() * 100) - 50;

            List<List<Integer>> result1 = solution.fourSum(nums, target);
            List<List<Integer>> result2 = bruteForceFourSum(nums, target);

            if (!compareResults(result1, result2)) {
                isCorrect = false;
                System.out.println("Test case failed:");
                System.out.println("Input array: " + Arrays.toString(nums));
                System.out.println("Target: " + target);
                System.out.println("Your result: " + result1);
                System.out.println("Expected result: " + result2);
                break;
            }
        }

        if (isCorrect) {
            System.out.println("All test cases passed!");
        } else {
            System.out.println("Some test cases failed.");
        }
    }

    // 生成随机数组
    private static int[] generateRandomArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }

    // 暴力解法作为对照
    private static List<List<Integer>> bruteForceFourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if ((long) nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(quad);
                            set.add(quad);
                        }
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }

    // 比较两个结果是否相等（无序）
    private static boolean compareResults(List<List<Integer>> result1, List<List<Integer>> result2) {
        Set<Set<Integer>> set1 = new HashSet<>();
        Set<Set<Integer>> set2 = new HashSet<>();

        for (List<Integer> list : result1) {
            set1.add(new HashSet<>(list));
        }
        for (List<Integer> list : result2) {
            set2.add(new HashSet<>(list));
        }
        return set1.equals(set2);
    }
}