package day11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值 中等 (
 * 遇到数字就放入栈内   遇到操作符就取出栈顶两个数字进行计算，并将结果压入栈中
 *
 */
public class Lc150_evalRPN {


    public int evalRPN(String[] tokens) {
        Deque<Integer> d = new LinkedList<>();
        for(String s : tokens){
            if("+".equals(s)) d.push(d.pop() + d.pop());
//            后弹出元素减去先弹出元素”的效果，因为在栈中，后进先出会导致先压入的元素在减法时应该作为减数，
//            后压入的元素应作为被减数。
            else if("-".equals(s)) d.push(-d.pop() + d.pop());
            else if("*".equals(s)) d.push(d.pop() * d.pop());
            else if("/".equals(s)){
                int n1 = d.pop();
                int n2 = d.pop();
                d.push(n2 / n1);
            }else d.push(Integer.valueOf(s));

        }
        return d.pop();
    }



    public static void main(String[] args) {
        Lc150_evalRPN evaluator = new Lc150_evalRPN();

        // 测试用例 1: 简单的加法表达式
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("测试用例 1 结果: " + evaluator.evalRPN(tokens1));  // 输出: 9

        // 测试用例 2: 包含减法和除法
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("测试用例 2 结果: " + evaluator.evalRPN(tokens2));  // 输出: 6

        // 测试用例 3: 复杂表达式
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("测试用例 3 结果: " + evaluator.evalRPN(tokens3));  // 输出: 22
    }

}
