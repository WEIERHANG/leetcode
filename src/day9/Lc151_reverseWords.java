package day9;



/**
 * 151. 反转字符串中的单词 中等   "the sky is blue"  --- >  "blue is sky the"
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 1.  依照单词为单位进行翻转(字母顺序不能变)
 * 2. 结果的前后不能有空格
 * 3. 单词之间如果有多个空格 只保留一个
 * --------
 * 整体思路就是
 * 1. 移除多余的空格
 * 2. 先全部翻转句子
 * 3. 翻转单词
 */
public class Lc151_reverseWords {
    public String reverseWords(String s) {
        //先转字符数组
        char[] chars = s.toCharArray();
        // 1. 处理空格
        chars = delSpaces(chars);
        // 2. 翻转句子
        reverse(chars, 0, chars.length - 1);
        // 3. 翻转单词
        reverseWord(chars);
        return new String(chars);
    }

    //1. 处理空格 去除首尾空格 以及中间只保留一个空格
    private char[] delSpaces(char[] chars) {
        int s = 0;
        for(int f = 0; f < chars.length; f++){
            // 先用f移除所有空格
            if(chars[f] != ' '){
                //在用s加空格 除了第一个单词外  单词的开头前加空格
                if(s != 0) chars[s++] = ' ';
                //f遇到空格或结束就代表遍历完一个单词了
                while (f < chars.length && chars[f] != ' ') chars[s++] = chars[f++];
            }
        }
        //返回结果
        char[] newChars = new char[s];
        System.arraycopy(chars, 0, newChars, 0, s);
        return newChars;
    }
    // 2. 翻转句子 双指针位运算
    private void reverse(char[] chars,int l,int r) {
        if(r >= chars.length) return;
        while (l < r){
            chars[l] ^= chars[r];
            chars[r] ^= chars[l];
            chars[l] ^= chars[r];
            l++;
            r--;
        }
    }
    // 3. 翻转单词
    private void reverseWord(char[] chars) {
        int start = 0;
        // <= 等于的原因是让end永远指向单词末尾后一个位置
        for(int end = 0; end <= chars.length; end++){
            // end到单词末尾后的空格或者串尾 就开始翻转单词
            if(end == chars.length || chars[end] == ' '){
                reverse(chars, start,end - 1);
                start = end + 1;
            }
        }
    }


    public static void main(String[] args) {
        Lc151_reverseWords solution = new Lc151_reverseWords();
        String result = solution.reverseWords("    i    love   you   ");
        System.out.println(result);
    }

}
