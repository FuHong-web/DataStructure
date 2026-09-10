package LeetCode_Revice5.hash;

import java.util.HashMap;
import java.util.Map;

/*两数之和*/
public class p1 {
    public int[] towNum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
