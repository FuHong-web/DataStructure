package LeetCode;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/17 9:23
 * @desc:力扣第169题
 */
public class Problem169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num) > nums.length /2){
                return num;
            }
        }
        return -1;
    }
}
