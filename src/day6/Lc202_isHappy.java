package day6;


import java.util.HashSet;
import java.util.Set;

/**
 * lc202 快乐数
 * 本题关键: 会无限循环 		一个多位数取出每位上的数
 */
public class Lc202_isHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && set.contains(n)){
            set.add(n);
            n = getNumber(n);
        }
        return n == 1;
    }
    public int getNumber(int n) {
        int res = 0;
        while (n > 0){
            int temp = n % 10; // 个位
            res += temp * temp; // 个位平方加到res里面
            n /= 10;  // 去掉n的个位数
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
