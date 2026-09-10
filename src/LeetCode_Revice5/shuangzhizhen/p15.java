package LeetCode_Revice5.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*三数之和*/
public class p15 {
    public List<List<Integer>> threeeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[i+1]){
                i++;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    while (left < right &&  nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right -1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
