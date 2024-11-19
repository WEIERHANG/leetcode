package day7;

import java.util.*;

public class Lc15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
//            第一个元素都大于0了 其余的全部不可能符合条件了
            if (nums[i] > 0) return res;
//            去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) r--;
                else if (sum < 0) l++;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    r--;
                    l++;
                }
            }
        }
        return res;
    }

    // 暴力解法，直接遍历所有可能的三数之和组合
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>(); // 用于去重
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // 排序以确保唯一性
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }
        res.addAll(uniqueTriplets);
        return res;
    }

    // 对数器方法
    public void runTest() {
        Random random = new Random();
        boolean isCorrect = true;

        // 测试多组随机数据
        for (int i = 0; i < 1000; i++) {
            int[] nums = random.ints(10, -10, 10).toArray(); // 随机生成长度为10的数组，范围为-10到10

            List<List<Integer>> result1 = threeSum(nums);
            List<List<Integer>> result2 = threeSumBruteForce(nums);

            // 对结果进行排序比较
            result1.sort(Comparator.comparingInt((List<Integer> a) -> a.get(0))
                    .thenComparingInt(a -> a.get(1))
                    .thenComparingInt(a -> a.get(2)));
            result2.sort(Comparator.comparingInt((List<Integer> a) -> a.get(0))
                    .thenComparingInt(a -> a.get(1))
                    .thenComparingInt(a -> a.get(2)));

            if (!result1.equals(result2)) {
                System.out.println("测试失败！");
                System.out.println("输入数组: " + Arrays.toString(nums));
                System.out.println("threeSum方法输出: " + result1);
                System.out.println("暴力解法输出: " + result2);
                isCorrect = false;
                break;
            }
        }

        if (isCorrect) {
            System.out.println("所有测试用例通过！");
        }
    }

    public static void main(String[] args) {
        Lc15_threeSum tester = new Lc15_threeSum();
        tester.runTest();
    }
}
