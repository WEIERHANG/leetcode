package day8;

import java.util.Arrays;
import java.util.Random;

public class Lc344_reverseString {

    // 原方法：使用双指针位运算反转字符串
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }

    // 对数器方法：使用简单的字符交换反转字符串
    public void reverseStringBaseline(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    // 对数器：生成随机字符数组，并比较结果
    public void testReverseString() {
        Random random = new Random();
        boolean allPassed = true;

        for (int i = 0; i < 1000; i++) { // 测试 1000 次
            int length = random.nextInt(100) + 1; // 随机长度 [1, 100]
            char[] s = new char[length];

            // 随机生成字符数组
            for (int j = 0; j < length; j++) {
                s[j] = (char) (random.nextInt(26) + 'a'); // 随机字母 'a' - 'z'
            }

            // 拷贝数组用于基准方法
            char[] sBaseline = Arrays.copyOf(s, s.length);
            char[] sTest = Arrays.copyOf(s, s.length);

            // 调用基准方法和测试方法
            reverseStringBaseline(sBaseline);
            reverseString(sTest);

            // 比较两个方法的结果
            if (!Arrays.equals(sBaseline, sTest)) {
                allPassed = false;
                System.out.println("测试失败！");
                System.out.println("原数组: " + Arrays.toString(s));
                System.out.println("基准方法结果: " + Arrays.toString(sBaseline));
                System.out.println("测试方法结果: " + Arrays.toString(sTest));
                break;
            }
        }

        if (allPassed) {
            System.out.println("所有测试通过！");
        }
    }

    public static void main(String[] args) {
        Lc344_reverseString solution = new Lc344_reverseString();
        solution.testReverseString();
    }
}
