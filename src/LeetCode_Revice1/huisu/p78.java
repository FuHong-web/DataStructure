package LeetCode_Revice1.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/12 22:57
 * @desc:子集
 */
public class p78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subSet(0,nums,res,temp);
        return res;
    }
    private void subSet(int index,int[] nums,List<List<Integer>> res,List<Integer> temp) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        subSet(index+1,nums,res,temp);
        temp.remove(temp.size()-1);

        subSet(index+1,nums,res,temp);
    }
}
