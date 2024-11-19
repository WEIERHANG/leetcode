package day8;

/**
 * lc541--反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，
 * 每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 */
public class Lc541_reverseStrII {

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔2k翻转前k
        for(int i = 0; i < ch.length; i += 2 * k){
            // 2. 剩余 >=x并且<2k 那就翻转前k
            if(i + k <= ch.length){
                reverse(ch, i, i + k - 1);
                continue;
            }
            //3. 剩余的<k 那就把剩余的全部翻转
            reverse(ch, i, ch.length - 1);
        }
        return new String(ch);

    }
    public void reverse(char[] ch, int i, int j) {
        while (i < j){
            ch[i] ^= ch[j];
            ch[j] ^= ch[i];
            ch[i] ^= ch[j];
            i++;
            j--;
        }
    }


    public static void main(String[] args) {

    }


}
