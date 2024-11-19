package interviewByHead;


import java.util.*;

/**
 * 有序数组的全排列 使用dfs
 *
 */
public class ArrayQuanPaiLie {


    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};
        List<Character> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) res.add(arr[i]);

        dfs(arr, 0, res);
    }

    private static void dfs(char[] arr, int index, List<Character> res) {
        if(index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        int len = res.size();
        for(int i = 0; i < len; i++){
            arr[index] = res.get(i);
            // 移除重复的 确保每个元素只出现一次
            Character remove = res.remove(i);
            dfs(arr, index + 1, res);
            res.add(i, remove);  // 回溯
        }
    }


}
