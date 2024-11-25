package day23;


import java.util.*;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串
 * 返回 s 所有可能的分割方案。  s 仅由小写英文字母组成
 * 回文串是向前和向后读都相同的字符串。
 */
public class Lc131_partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s, path, res, 0);
        return res;
    }

    private void backtracking(String s, List<String> path, List<List<String>> res, int sIndex) {
        if(sIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = sIndex; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(check(sb)){
                path.add(sb.toString());
                backtracking(s, path, res, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    // 双指针判断是否为回文子串
    public boolean check(StringBuilder sb){
        for (int i = 0; i < sb.length() / 2; i++){
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // 创建 Lc131_partition 对象
        Lc131_partition lc131 = new Lc131_partition();

        // 测试用例
        String s = "aab";
        System.out.println("输入字符串: " + s);

        // 调用 partition 方法
        List<List<String>> result = lc131.partition(s);

        // 输出结果
        System.out.println("分割回文子串的所有方案: ");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}