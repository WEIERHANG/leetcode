package day24;

import java.util.*;


/**
 * 93. 复原 IP 地址 -- 中等
 *
 */
public class Lc93_restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s); // 初始化 StringBuilder
        backtracking(sb, res, 0, 0); // 调用回溯方法
        return res;
    }

    public void backtracking(StringBuilder s, List<String> res, int pointSum, int sIndex) {
        // 如果已经插入3个点，检查最后一段是否合法
        if (pointSum == 3 && check(s, sIndex, s.length() - 1)) {
            res.add(s.toString()); // 添加合法结果
            return;
        }

        for (int i = sIndex; i < s.length(); i++) {
            if (check(s, sIndex, i)) { // 检查当前段是否合法
                s.insert(i + 1, '.'); // 插入点
                backtracking(s, res, pointSum + 1, i + 2); // 递归调用
                s.deleteCharAt(i + 1); // 回溯，删除点
            } else {
                break; // 如果当前段不合法，直接退出
            }
        }
    }

    public boolean check(StringBuilder s, int l, int r) {
        if (l > r) return false; // 起始位置大于结束位置
        if (s.charAt(l) == '0' && l != r) return false; // 前导0不合法
        int size = 0;
        for (int i = l; i <= r; i++) {
            int digit = s.charAt(i) - '0'; // 将字符转为数字
            size = size * 10 + digit;
            if (size > 255) return false; // 超过255不合法
        }
        return true;
    }

    // 测试用例
    public static void main(String[] args) {
        Lc93_restoreIpAddresses solution = new Lc93_restoreIpAddresses();
        System.out.println(solution.restoreIpAddresses("25525511135")); // [255.255.11.135, 255.255.111.35]
        System.out.println(solution.restoreIpAddresses("0000"));        // [0.0.0.0]
        System.out.println(solution.restoreIpAddresses("101023"));      // [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
    }
}
