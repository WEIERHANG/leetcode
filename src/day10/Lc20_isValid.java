package day10;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 */
public class Lc20_isValid {


    public boolean isValid(String s) {
        // 如果长度是奇数 那一定不满足要求
        if(s.length() % 2 != 0) return false;

        Deque<Character> deque = new LinkedList<>();
        char ch;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if(ch == '(') deque.push(')');
            else if (ch == '{') deque.push('}');
            else if(ch == '[') deque.push(']');
            // 情况23
            else if (deque.isEmpty() || deque.peek() != ch) return false;
            else deque.pop();
        }
        // 情况1 字符串便利完了 但是栈不为空
        return deque.isEmpty();


    }

    public static void main(String[] args) {
        Lc20_isValid validator = new Lc20_isValid();

        // 测试用例
        System.out.println(validator.isValid("()"));         // true
        System.out.println(validator.isValid("()[]{}"));     // true
        System.out.println(validator.isValid("(]"));         // false
        System.out.println(validator.isValid("([)]"));       // false
        System.out.println(validator.isValid("{[]}"));       // true
        System.out.println(validator.isValid("["));          // false
        System.out.println(validator.isValid(""));           // true
    }




}
