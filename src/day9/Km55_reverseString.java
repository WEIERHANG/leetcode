package day9;

import java.util.Scanner;

/**
 * 右旋字符串
 * 对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 *
 */
public class Km55_reverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int len = s.length(); //字符串长度
        char[] chars = s.toCharArray(); //转字符数组
        reverseString(chars, 0, len - 1); // 翻转整个
        reverseString(chars, 0, n - 1); // 翻转也就是原本的第二段 翻转之后就是0到n-1
        reverseString(chars, n, len - 1); //后一段
        System.out.println(chars);

    }

    public static void reverseString(char[] ch, int l, int r) {
        while (l < r){
            ch[l] ^= ch[r];
            ch[r] ^= ch[l];
            ch[l] ^= ch[r];
            l++;
            r--;
        }

    }
}
