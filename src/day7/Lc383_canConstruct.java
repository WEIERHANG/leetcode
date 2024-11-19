package day7;

/**
 * 给你两个字符串：ransomNote 和 magazine ，
 * 判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 242.有效的字母异位词 是一个思路 ，算是拓展题
 *
 * lc242是求字符串a 和 字符串b 是否可以相互组成
 * lc383是求字符串a能否组成字符串b，而不用管字符串b 能不能组成字符串a
 * 题意得出 magazines里面元素不能重复使用   只有小写
 */
public class Lc383_canConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] res = new int[26];

        for (char c : magazine.toCharArray()) res[c - 'a']++;

        for (char c : ransomNote.toCharArray()) res[c - 'a']--;

        for (int i : res) {
            if (i < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc383_canConstruct solution = new Lc383_canConstruct();

        // 测试用例
        String[][] testCases = {
                {"a", "b"},         // false, 因为 b 中没有字符 'a'
                {"aa", "ab"},       // false, b 中只有一个 'a'
                {"aa", "aab"},      // true, 因为 b 有足够的字符 'a' 和 'b'
                {"hello", "hlloe"}, // true, 因为 b 可以重排成 a
                {"abc", "cba"},     // true, b 包含足够的字符 'a'，'b'，'c'
                {"aaa", "aa"},      // false, 因为 b 中只有两个 'a'
                {"a", "a"}          // true, 因为 b 中有一个 'a'
        };

        for (String[] testCase : testCases) {
            String ransomNote = testCase[0];
            String magazine = testCase[1];
            boolean result = solution.canConstruct(ransomNote, magazine);
            System.out.printf("ransomNote: \"%s\", magazine: \"%s\" -> %s%n", ransomNote, magazine, result);
        }
    }
}
