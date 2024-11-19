package day2;

import java.util.*;

/**
 * 前缀和
 * 给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
 *
 * 输入描述
 *
 * 第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，
 * 表示数组的元素。随后的输入为需要计算总和的区间，直至文件结束。
 *
 * 输出描述
 * 输出每个指定区间内元素的总和
 */
public class PreSumArr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vec = new int[n]; //原本数组
        int[] p = new int[n];  //原本数组的区间和
        // 计算原本数组的区间和
        int preSum = 0;
        for(int i = 0; i < n; i++){
            vec[i] = sc.nextInt();
            preSum += vec[i];
            p[i] = preSum;
        }

        while (sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = 0;
            if(a == 0) sum = p[b];
            else sum = p[b] - p[a - 1];
            System.out.println(sum);
        }

    }
}
