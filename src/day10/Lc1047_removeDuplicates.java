package day10;

import java.util.ArrayDeque;
import java.util.Random;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 */
public class Lc1047_removeDuplicates {

    public String removeDuplicates(String s) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        char ch;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if(q.isEmpty() || q.peek() != ch) q.push(ch);
            else q.pop();
        }
        String res = "";

        while(!q.isEmpty()) res = q.pop() + res;
        return res;
    }
    // 暴力解法
    public String bruteForceRemoveDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean hasDuplicates;
        do {
            hasDuplicates = false;
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    sb.delete(i - 1, i + 1);
                    hasDuplicates = true;
                    break;
                }
            }
        } while (hasDuplicates);
        return sb.toString();
    }

    // 对数器测试
    public void test() {
        Random random = new Random();
        boolean allPassed = true;
        for (int i = 0; i < 1000; i++) {
            // 生成随机字符串，长度为10~20，包含小写字母
            int length = 10 + random.nextInt(11);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append((char) ('a' + random.nextInt(26)));
            }
            String testString = sb.toString();

            // 使用两种方法计算结果
            String result1 = removeDuplicates(testString);
            String result2 = bruteForceRemoveDuplicates(testString);

            // 比较结果
            if (!result1.equals(result2)) {
                System.out.println("测试失败！");
                System.out.println("测试字符串: " + testString);
                System.out.println("removeDuplicates结果: " + result1);
                System.out.println("bruteForceRemoveDuplicates结果: " + result2);
                allPassed = false;
                break;
            }
        }
        if (allPassed) {
            System.out.println("所有测试均通过！");
        }
    }

    public static void main(String[] args) {
        Lc1047_removeDuplicates validator = new Lc1047_removeDuplicates();
        validator.test();
    }
}