package day6;

/**
 *  lc242有效的字母异位词 --- 哈希表章节  数组  set  map
 *  也就是给定两个字符串 判断这两个字符串是不是有相同的字符组成 不管顺序
 *  abbc ---  bbac
 *  ---------
 *
 *
 *
 *
 */
public class Lc242_isAnagram {

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) arr[s.charAt(i) - 'a']++;

        for(int i = 0; i < t.length(); i++) arr[t.charAt(i) - 'a']--;

        for(int c : arr){
            if(c != 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {

    }
}
