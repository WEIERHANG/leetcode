package day22;


import java.util.ArrayList;
import java.util.List;

/**
 * lc17-电话号码的字母组合  -- 中等
 *
 */
public class Lc17_letterCombinations {


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        if(digits == null || digits.length() == 0) return res;
        String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(digits, numString, 0, res, path);
        return res;

    }
    public void backtracking(String digits, String[] numString, int num, List<String> res,StringBuilder path) {
        if(num == digits.length()){
            res.add(path.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
        for(int i = 0; i < str.length(); i++){
            path.append(str.charAt(i));
            backtracking(digits, numString, num + 1, res,path);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        Lc17_letterCombinations solution = new Lc17_letterCombinations();

        // 测试用例 1
        String digits1 = "23";
        System.out.println("输入: " + digits1);
        List<String> result1 = solution.letterCombinations(digits1);
        System.out.println("输出: " + result1);

        // 测试用例 2
        String digits2 = "7";
        System.out.println("输入: " + digits2);
        List<String> result2 = solution.letterCombinations(digits2);
        System.out.println("输出: " + result2);

        // 测试用例 3
        String digits3 = "";
        System.out.println("输入: " + digits3);
        List<String> result3 = solution.letterCombinations(digits3);
        System.out.println("输出: " + result3);

        // 测试用例 4
        String digits4 = "9";
        System.out.println("输入: " + digits4);
        List<String> result4 = solution.letterCombinations(digits4);
        System.out.println("输出: " + result4);
    }
}