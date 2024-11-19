package day6;


import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 *
 */
public class Lc1_twoSum {
    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }


}
